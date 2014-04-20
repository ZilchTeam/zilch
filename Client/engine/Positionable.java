// Запил передвигающегося нечто.

package engine;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class Positionable {
	Point position = new Point();
	Point defaultPosition = new Point();
	Rectangle bounds = null; // Границы
	Point vec;
	
	
	public void setBounds(Rectangle rect) {
		this.bounds = rect;
	}
	
	public void setBounds(int x, int y, int width, int height) {
		this.bounds = new Rectangle(x, y, width, height);
	}
	
	public void setDefaultPosition(int x, int y) {
		this.setDefaultPosition(new Point(x, y));
	}
	
	public void setDefaultPosition(Point p) {
		this.defaultPosition = p;
		this.setPosition(this.defaultPosition);
	}
	
	public Point getDefaultPosition() {
		return this.defaultPosition;
	}
	
	public void resetPosition() {
		this.setPosition(defaultPosition);
	}
	
	public void setPosition(Point p) {
		this.setX(p.x);
		this.setY(p.y);
	}
	
	public void setPosition(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void setX(int x) {
		if (this.bounds != null) {
			if (x < bounds.x || x > bounds.width)
				return;
		}
		
		this.position.x = x;
	}
	
	public void setY(int y) {
		if (this.bounds != null) {
			if (y < bounds.y || y > bounds.height)
				return;
		}
		
		this.position.y = y;
	}
	
	public int getX() {
		return (int) this.position.x;
	}
	
	public int getY() {
		return (int) this.position.y;
	}
}
