package Server;

import engine.Keys;

import java.awt.*;
import java.util.ArrayList;

public class Player extends LivingObject {
    public static int playersCount = 0;

    private int id;


    public Player (Point location, int size, Color color, String shape, Boolean pass, int speed, String name) {
        super(location, size, color, shape, pass, name, speed);

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
        setY(getY() - 1);
        //location.y -= 1; //++взаимодействие с Speed
    }
    public void SKeyPress() {
        setY(getY() + 1);
        //location.y += 1; //++взаимодействие с Speed
    }
    public void AKeyPress() {
        setX(getX() - 1);
        //location.x -= 1; //++взаимодействие с Speed
    }
    public void DKeyPress() {
        setX(getX() + 1);
        //location.x += 1; //++взаимодействие с Speed
    }
}
