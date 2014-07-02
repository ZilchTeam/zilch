// Камера. вроде как плавающяя - то что надо. Разобрать.

package engine;

import java.awt.*;

public class Camera extends Positionable {
	
	// Порт просмотра - в данном случае в порт попадает вся карта.
	private Dimension viewport;

	public Camera() {
		this.setX(0);
		this.setY(0);
		this.viewport = GameFrame.getInstance().getSize();
		
		// Установить границы.
		this.setBounds(0, 0, viewport.width, viewport.height);
	}
	
	public Dimension getViewport() {
		return viewport;
	}

	public void follow(Positionable p) {
		this.setX(p.getX() - (viewport.width / 2));
		this.setY(p.getY() - (viewport.height / 2));
	}
}