package Server;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public abstract class BaseClass implements Serializable{
	private Point location;
	private int size; // ?
	private Color color;
	private String shape;// ?
	private Boolean pass;

    public int getX() { return location.x; }
    public void setX(int X) { location.x = X; }

    public int getY() { return location.y; }
    public void setY(int Y) { location.y = Y; }

	public BaseClass(Point location, int size, Color color, String shape, Boolean pass) {
		this.location = location ;
		this.size = size;
		this.color = color;
		this.shape = shape;
		this.pass = pass;
	}

}
