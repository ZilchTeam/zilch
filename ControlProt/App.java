package game;

import java.awt.*; 
import java.awt.image.*;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import PersProt.PersProt;
import engine.GameCanvas;
import engine.GameFrame;
import engine.Input;
import engine.Keys;
//import engine.Image;



public class App {	
	
	private PersProt persProt;
	Input input = new Input();
	
	public App() {

		GameFrame app = GameFrame.getInstance();	// Форма делается так а не через конструктор.
		app.setSize(600, 600); 
		persProt = new PersProt(0, 0);
		Scene scene = new Scene(persProt);	// Своя сцена.
		app.begin(scene);					// Скармливаем сцену.
		scene.addKeyListener(input);		//подпись на события мыши и клавы
		scene.addMouseListener(input);
		scene.addMouseMotionListener(input);
	}


	public static void main(String[] args){
		new App();
	}
}

class Scene extends GameCanvas {

	private static final long serialVersionUID = 2L;

	private PersProt persProt;
	private Image img = new ImageIcon("arrow.png").getImage();
	private AffineTransform at;
	private double Angle;
	private BufferedImage 	original_img,
	 						rotated_img;
	private AffineTransformOp atOp;
	private int h = img.getHeight(null),
				w = img.getWidth(null);
	
	public Scene(PersProt inpersProt) {
		
		persProt = inpersProt;
		setSize(100, 100);
		
        original_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 =  original_img.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose(); //освобождает все системные ресурсы, что использует
        rotated_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	}
	
	@Override
	public void update(float elapsedTime) {
		
		if (Input.isKeyDown(Keys.DOWN) || Input.isKeyDown(Keys.S))	//down (стрелка или S)
			persProt.setY(persProt.getY() + 1);	//TODO:отправить на сервер ^
		if (Input.isKeyDown(Keys.UP) || Input.isKeyDown(Keys.W))	//up (стрелка или W)
			persProt.setY(persProt.getY() - 1);	//TODO:отправить на сервер v
		if (Input.isKeyDown(Keys.LEFT) || Input.isKeyDown(Keys.A))	//left (стрелка или A)
			persProt.setX(persProt.getX() - 1);	//TODO:отправить на сервер <
		if (Input.isKeyDown(Keys.RIGHT) || Input.isKeyDown(Keys.D))	//right (стрелка или D)
			persProt.setX(persProt.getX() + 1);	//TODO:отправить на сервер >
		if (Input.isKeyDown(Keys.SPACE)) { //переместить в центр
			persProt.setX(getWidth()/2);
			persProt.setY(getHeight()/2);
		}
	}

	@Override
	public void draw(Graphics g, float elapsedTime) {	// Рисовалка тут.
		
		//определяем угол на который нужно повернуть изображение в радианах
		Angle =Math.PI-Math.atan2((persProt.getX()-Input.getMousePosition().x),(persProt.getY()-Input.getMousePosition().y));
		
		at = new AffineTransform();
		at.setToRotation(Angle, w/2, h/2); //поворачиваем изображение и смещаем на половину по X и Y ,для того чтобы осью вращения был центр изображения
		atOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        atOp.filter(original_img, rotated_img);
       
        g.drawImage(rotated_img, (int)persProt.getX(), (int) persProt.getY(), null);
        //g.setColor(Color.GREEN);
        //g.fillRect((int) persProt.getX(), (int) persProt.getY(), 32, 32);
	}
}