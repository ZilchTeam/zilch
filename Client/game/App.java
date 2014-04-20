package game;

import java.awt.Graphics;

import engine.GameCanvas;
import engine.GameFrame;

public class App {
	
	public static void main(String[] args){
		GameFrame app = GameFrame.getInstance(); // Форма делается так а не через конструктор.
		app.setSize(400, 300); 
		Scene scene = new Scene(); 	// Своя сцена.
		app.begin(scene);			// Скармливаем сцену.
		System.out.println("test");
	}
}

class Scene extends GameCanvas {

	private static final long serialVersionUID = 2L;

	public Scene() {
		setSize(100, 100);
	}
	
	@Override
	public void update(float elapsedTime) {  // Хз че это.
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics g, float elapsedTime) { // Рисовалка тут.
		g.drawRect(10, 10, 50, 50);
	}
}