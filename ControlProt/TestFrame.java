import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestFrame extends JFrame {

	private Scene scene;
	private PersProt persProt;

	public TestFrame() {
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		persProt = new PersProt(5, 5);
		scene = new Scene(persProt);
		
		setBackground(Color.cyan);
		setVisible(true);
		add(scene, BorderLayout.CENTER);

		scene.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				switch (KeyEvent.getKeyText(e.getKeyCode())) {
				case "Up":
				case "W":
					persProt.setY(persProt.getY() - 5);
					break;

				case "Left":
				case "A":
					persProt.setX(persProt.getX() - 5);
					break;

				case "Down":
				case "S":
					persProt.setY(persProt.getY() + 5);
					break;

				case "Right":
				case "D":
					persProt.setX(persProt.getX() + 5);
					break;

				default:
					System.out.println("nope "
							+ KeyEvent.getKeyText(e.getKeyCode()));
					break;
				}
				scene.repaint();
			}
		});
	}

	public static void main(String[] args) {
		new TestFrame();
	}
}
