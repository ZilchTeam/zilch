package game;

import java.awt.Color;
import java.awt.Graphics;

import PersProt.PersProt;
import engine.GameCanvas;
import engine.GameFrame;
import engine.Input;
import engine.Keys;

public class App {	
	private PersProt persProt;
	public App() {
		GameFrame app = GameFrame.getInstance();	// Форма делается так а не через конструктор.
		app.setSize(600, 600); 
		persProt = new PersProt(0, 0);
		Scene scene = new Scene(persProt);	// Своя сцена.
		app.begin(scene);					// Скармливаем сцену.
		scene.addKeyListener(new Input());	//подпись на события мыши и клавы
	}
	
	public static void main(String[] args){
		new App();
	}
}

class Scene extends GameCanvas {

	private static final long serialVersionUID = 2L;

	private PersProt persProt;
	
	public Scene(PersProt inpersProt) {
		persProt = inpersProt;
		setSize(100, 100);
	}
	
	@Override
	public void update(float elapsedTime) {
		if (Input.isKeyDown(Keys.indexOf(40)) || Input.isKeyDown(Keys.indexOf(83)))	//down (стрелка или S)
			persProt.setY(persProt.getY() + 1);	//TODO:отправить на сервер ^
		if (Input.isKeyDown(Keys.indexOf(38)) || Input.isKeyDown(Keys.indexOf(87)))	//up (стрелка или W)
			persProt.setY(persProt.getY() - 1);	//TODO:отправить на сервер v
		if (Input.isKeyDown(Keys.indexOf(37)) || Input.isKeyDown(Keys.indexOf(65)))	//left (стрелка или A)
			persProt.setX(persProt.getX() - 1);	//TODO:отправить на сервер <
		if (Input.isKeyDown(Keys.indexOf(39)) || Input.isKeyDown(Keys.indexOf(68)))	//right (стрелка или D)
			persProt.setX(persProt.getX() + 1);	//TODO:отправить на сервер >
	}

	@Override
	public void draw(Graphics g, float elapsedTime) {	// Рисовалка тут.
		g.setColor(Color.GREEN);
		g.fillRect((int) persProt.getX(), (int) persProt.getY(), 32, 32);
	}
}