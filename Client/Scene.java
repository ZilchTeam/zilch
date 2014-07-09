package Client;

import ISend.ISend;
import Server.GameObject;
import engine.GameCanvas;
import engine.Input;
import engine.Keys;
import engine.MouseButton;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.util.ArrayList;

class Scene extends GameCanvas {
    private Image   banan = new ImageIcon("ban.png").getImage(),
                    img = new ImageIcon("arrow.png").getImage();

    private ArrayList<GameObject> visibleObj;
    private AffineTransform at;
    private double Angle;
    private BufferedImage original_img, rotated_img ;
    private AffineTransformOp atOp;
    private int     h = img.getHeight(null),
                    w = img.getWidth(null);
    private ISend send;

    public Scene(ISend send) {
        this.send = send;

        original_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 =  original_img.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose(); //освобождает все системные ресурсы, что использует
        rotated_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void update(float elapsedTime) throws RemoteException {
        //меню вызывается нажатием клавиши escape
        if (Input.isKeyDown(Keys.ESCAPE)) {
            App.GAME_STATE = App.MENU;
        }

        //если в состоянии игры , то отправлять на нажатые клавиши и принимать список для отрисовки
        if (App.GAME_STATE == App.GAME) { //отправить на сервер список нажатых клавиш + идентификатор игрока
            try {
                send.setPressedKeys(Input.getPressedKeys(), App.id);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            //обновить список объектов для отрисовки на карте(пока только объекты игроков)
            try {
                visibleObj = send.getList();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Graphics g, float elapsedTime) {	// Рисовалка тут.
        if (App.GAME_STATE == App.MENU) {
            drawMenu(g); //отрисовать велосипедное меню
        }

        if (App.GAME_STATE == App.GAME) {
            //отрисовать все объекты(пока только игроки)
            for (int i = 0; i < visibleObj.size(); i++) {
                GameObject obj = visibleObj.get(i);

                //определяем угол на который нужно повернуть изображение в радианах
                Angle = Math.PI - Math.atan2((obj.getX() - Input.getMousePosition().x), (obj.getY() - Input.getMousePosition().y));
                at = new AffineTransform();
                at.setToRotation(Angle, w / 2, h / 2); //поворачиваем изображение и смещаем на половину по X и Y ,для того чтобы осью вращения был центр изображения
                atOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                atOp.filter(original_img, rotated_img);

                g.setColor(obj.getColor());
                //над игроками ники
                if (obj.getName() != null) {
                    g.drawString(obj.getName(), obj.getX(), obj.getY());
                    g.drawImage(rotated_img, obj.getX(), obj.getY(), null);
                } else {
                    g.drawString("no life", obj.getX(), obj.getY());
                    g.drawImage(banan, obj.getX(), obj.getY(), null);
                }

                g.setColor(Color.white);
            }
        }
    }

    public void drawMenu(Graphics g) {//костыльно-ориентированное меню
        g.setColor(Color.black);
        g.fillRect(100, 100, getWidth() - 200, getHeight() - 200);
        g.setColor(Color.white);
        g.setFont(new Font("Font",Font.ROMAN_BASELINE,40));
        g.drawString("Menu",250, 140);

        //первая кнопка
        Rectangle butt1 = new Rectangle(220,180,170,40);
        //g.drawRect((int)butt1.getX(),(int)butt1.getY(),(int)butt1.getWidth(),(int)butt1.getHeight());
        if ( butt1.getHeight() + butt1.getY() > Input.getMousePosition().y &&
             butt1.getY() < Input.getMousePosition().y &&
             butt1.getX() < Input.getMousePosition().x &&
             butt1.getWidth() + butt1.getX() > Input.getMousePosition().x ) {

            g.setColor(Color.red);
            if (Input.isMouseDown(MouseButton.LEFT)) {
                App.id = 1;
                App.GAME_STATE = App.GAME;
            }
        }
        g.drawString("Login to 1",butt1.x, butt1.y+40);
        g.setColor(Color.white);

        //вторая кнопка
        Rectangle butt2 = new Rectangle(220,240,170,40);
        //g.drawRect((int)butt2.getX(),(int)butt2.getY(),(int)butt2.getWidth(),(int)butt2.getHeight());
        if ( butt2.getHeight() + butt2.getY() > Input.getMousePosition().y &&
             butt2.getY() < Input.getMousePosition().y &&
             butt2.getX() < Input.getMousePosition().x &&
             butt2.getWidth() + butt2.getX() > Input.getMousePosition().x ) {

            g.setColor(Color.red);
            if (Input.isMouseDown(MouseButton.LEFT)) {
                App.GAME_STATE = App.GAME;
            }
        }
        g.drawString("Resume",butt2.x, butt2.y+40);
        g.setColor(Color.white);

        //третья кнопка
        Rectangle butt3 = new Rectangle(220,300,170,40);
        //g.drawRect((int)butt3.getX(),(int)butt3.getY(),(int)butt3.getWidth(),(int)butt3.getHeight());
        if ( butt3.getHeight() + butt3.getY() > Input.getMousePosition().y &&
                butt3.getY() < Input.getMousePosition().y &&
                butt3.getX() < Input.getMousePosition().x &&
                butt3.getWidth() + butt3.getX() > Input.getMousePosition().x ) {

            g.setColor(Color.red);
            if (Input.isMouseDown(MouseButton.LEFT)) {
                System.exit(0);
            }
        }
        g.drawString("Exit",butt3.x, butt3.y+40);
        g.setColor(Color.white);
    }
}