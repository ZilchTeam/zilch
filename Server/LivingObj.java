package Server;

import java.awt.*;

public class LivingObj extends BaseClass {
    private Point location;
    private int size;
    private Color color;
    private String shape;
    private Boolean pass;
    private int speed;

    @Override
    public String getName() {
        return null;
    }

    public LivingObj(Point location, int size, Color color, String shape, Boolean pass, int speed) {
        super(location, size, color, shape, pass);
        this.speed = speed;
    }

    public void Move() {
    }


}
