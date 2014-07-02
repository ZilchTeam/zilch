// Главное окно игры

package engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public static GameFrame instance; // Ссылка на себя. Доступна из любого места программы.
	
	protected GameFrame() {
		super();
	}

	// Одиночка.
	public static GameFrame getInstance() {
		if (instance == null) {
			instance = new GameFrame();
			instance.setResizable(false);
		}
		return instance;
	}
	
	public void begin(GameCanvas game) {
		game.setBounds(this.getBounds());
		game.setBackground(game.getClearColor());
		game.setIgnoreRepaint(true);

		
		this.add(game);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	    
	    this.setVisible(false);
	    this.dispose();

	    System.exit(0); 
	}
}