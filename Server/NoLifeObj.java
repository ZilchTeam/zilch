package Server;

import java.awt.*;

public class NoLifeObj extends BaseClass {
    private Point location;
    private int size; // ?
    private Color color;
    private String shape;// ?
    private Boolean pass;

    public NoLifeObj(Point location, int size, Color color, String shape, Boolean pass) {
        super(location, size, color, shape, pass);
    }
}
