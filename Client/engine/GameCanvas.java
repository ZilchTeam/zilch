// Сцена - поддерживает двойную буферизацию, можно менять количесто ФПС.
// Содержит поток для отрисовки.
// Абстрактная - где реализация не нашел.

package engine;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class GameCanvas extends Canvas implements Runnable, Drawable {
    private static final long serialVersionUID = 1L;

    public static volatile boolean gameRunning = true;

    private Thread game;
    private BufferStrategy buffer;
    private Graphics graphics;
    private Color clearColor = Color.WHITE;

    public GameCanvas() {}
    public abstract void update(float elapsedTime);
    public abstract void draw(Graphics g, float elapsedTime); // Все что описано в это функции будет отрисовано в рендер.

    public void stop() {
        gameRunning = false;
    }

    public void addInputHandler(Input input) {
        this.addKeyListener(input);
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public Color getClearColor() {
        return this.clearColor;
    }

    public void setClearColor(Color color) {
        this.clearColor = color;
    }

    final int TARGET_FPS = 60; // this is a very rough approximation due to how currentTimeMillis() works on Windows
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;

    float interpolation;
    long next_game_tick, lastUpdate = System.currentTimeMillis();
    int loops;
    float lastInterpol = 0;

    @Override
    public void run() {
        while (gameRunning) {
            loops = 0;

            while (System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP) {
                this.update(lastInterpol);
                next_game_tick += SKIP_TICKS;
                loops++;
            }

            lastInterpol = interpolation =
                    (float) ((System.currentTimeMillis()  + SKIP_TICKS - next_game_tick) / lastUpdate + (float) (SKIP_TICKS)) / 2.4f;
            // passed to Render so you can interpolate object positions based on the frame rate
            // to make it smoother on higher end systems

            this.render(interpolation);
            this.paint(); // flushes the buffer and paints on the screen; the real drawing is done in render()

            try {
                Thread.sleep( Math.max( (1000/TARGET_FPS) - (System.currentTimeMillis() - lastUpdate), 0) );
            } catch (InterruptedException ie) {}

            lastUpdate = System.currentTimeMillis();
        }
    }

    private void render(float elapsedTime) {
        try {
            graphics = buffer.getDrawGraphics();
            graphics.setColor(clearColor);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

            graphics.setColor(Color.BLACK);

            this.draw(graphics, elapsedTime);
        } catch (Exception e) {
            // we are closing or cannot run the game for whatever screwy reason, just terminate
            System.exit(0);
        }
    }

    private void paint() {
        if (!buffer.contentsLost()) {
            buffer.show();
            if (graphics != null) {
                graphics.dispose();
            }
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();

        this.createBufferStrategy(2);
        this.buffer = this.getBufferStrategy();

        game = new Thread(this);
        game.start();
    }

    @Override
    public boolean isFocusTraversable() {
        return true;
    }
}