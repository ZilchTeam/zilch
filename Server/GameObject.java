package Server;

import java.awt.*;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public abstract class GameObject extends Observable implements Serializable, Observer {
	private Point location;
	private int size; // ?
	private Color color;
	private String shape;// ?
	private Boolean pass;
    private String name;

    public Point getLocation() {
        return location;
    }
    public void setLocation(Point location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public int getX() {
        return location.x;
    }
    public void setX(int X) {
        location.x = X;
    }

    public int getY() {
        return location.y;
    }
    public void setY(int Y) {
        location.y = Y;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }
    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public GameObject(Point location, int size, Color color, String shape, Boolean pass, String name) {
		this.location = location ;
		this.size = size;
		this.color = color;
		this.shape = shape;
		this.pass = pass;
        this.name = name;
	}
}
