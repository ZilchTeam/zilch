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
    //private String name;

    public Point getLocation() { return location; }
    public void setLocation(Point location) { this.location = location; }

    public int getX() { return location.x; }
    public void setX(int X) { location.x = X; }

    public int getY() { return location.y; }
    public void setY(int Y) { location.y = Y; }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public String getShape() { return shape; }
    public void setShape(String shape) { this.shape = shape; }

    public abstract String getName();

	public BaseClass(Point location, int size, Color color, String shape, Boolean pass) {
		this.location = location ;
		this.size = size;
		this.color = color;
		this.shape = shape;
		this.pass = pass;
	}

}
