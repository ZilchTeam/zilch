import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Scene extends Canvas {
	
	PersProt persProt;
	
	public Scene(PersProt PersProt) {
		persProt = PersProt;
		setBackground(Color.white);
	}

	public void paint(Graphics g) {

		g.setColor(Color.GREEN);
		g.fillRect((int) persProt.getX(), (int) persProt.getY(), 32, 32);
	}
}
