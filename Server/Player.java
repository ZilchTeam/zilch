package Server;

import engine.Keys;

import java.awt.*;
import java.util.ArrayList;

public class Player extends LivingObj {
    public static int playersCount = 0;

    private Point location = new Point(0,0);
    private int size = 1;
    private Color color = Color.black;
    private String name;
    private String shape;
    private Boolean pass = true;
    private int speed = 1;
    private int id;

    @Override
    public String getName() {
        return name;
    }

    public Player (Point location, int size, Color color, String shape, Boolean pass, int speed, String name) {
        super(location, size, color, shape, pass, speed);
        this.location = location;
        this.size = size;
        this.color = color;
        this.shape = shape;
        this.pass = pass;
        this.speed = speed;
        this.name = name;
        id = playersCount;
        playersCount++;
    }

    public void Move(ArrayList<Keys> pressedKeys) {
        if (pressedKeys.contains(Keys.W))
            WKeyPress();
        if (pressedKeys.contains(Keys.S))
            SKeyPress();
        if (pressedKeys.contains(Keys.A))
            AKeyPress();
        if (pressedKeys.contains(Keys.D))
            DKeyPress();
    }

    public void WKeyPress() {
        location.y -= 1; //++взаимодействие с Speed
    }
    public void SKeyPress() {
        location.y += 1; //++взаимодействие с Speed
    }
    public void AKeyPress() {
        location.x -= 1; //++взаимодействие с Speed
    }
    public void DKeyPress() {
        location.x += 1; //++взаимодействие с Speed
    }
}
