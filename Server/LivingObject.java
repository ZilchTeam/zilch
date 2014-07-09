package Server;

import java.awt.*;
import java.util.Observable;

public class LivingObject extends GameObject {

    private int speed;

    public LivingObject(Point location, int size, Color color, String shape, Boolean pass,String name, int speed) {
        super(location, size, color, shape, pass, name);
        this.speed = speed;
    }

    public void Move() {
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
