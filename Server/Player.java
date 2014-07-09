package Server;

import engine.Keys;


import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Player extends LivingObject {
    public static int playersCount = 0;

    private int id;
    private boolean block = false;

    public Player (Point location, int size, Color color, String shape, Boolean pass, int speed, String name) {
        super(location, size, color, shape, pass, name, speed);
        id = playersCount;
        playersCount++;
    }

    public void Move(ArrayList<Keys> pressedKeys) {

        if (!block) {
            if (pressedKeys.contains(Keys.W))
                WKeyPress();
            if (pressedKeys.contains(Keys.S))
                SKeyPress();
            if (pressedKeys.contains(Keys.A))
                AKeyPress();
            if (pressedKeys.contains(Keys.D))
                DKeyPress();
        }
        notifyObservers(new CommonData(getLocation(), getSize(), getName(), getShape()));
    }

    public void WKeyPress() {
        setY(getY() - 1);
        setChanged();
        //++взаимодействие с Speed
    }
    public void SKeyPress() {
        setY(getY() + 1);
        setChanged();
        //++взаимодействие с Speed
    }
    public void AKeyPress() {
        setX(getX() - 1);
        setChanged();
        //++взаимодействие с Speed
    }
    public void DKeyPress() {
        setX(getX() + 1);
        setChanged();
        //++взаимодействие с Speed
    }

    @Override
    public void update(Observable o, Object arg) {
        CommonData data = (CommonData) arg;
        Rectangle rectangle = new Rectangle(data.location, new Dimension(data.size, data.size));
        Rectangle rectangleThis = new Rectangle(getLocation(), new Dimension(getSize(),getSize()));
        if (rectangleThis.intersects(rectangle)) {
            block = true;
            setChanged();
        }
        else
            block = false;
    }
/*

        //возможный вариант распознование формы
        switch (data.shape) {
            case ("Rectangle"):

                Rectangle rectangle = new Rectangle(data.location, data.size);
                Rectangle rectangleThis = new Rectangle(getLocation(), getSize());
                break;
            case ("Circle"):
                Circle circle = new Circle(data.location.getX(),data.location.getY(),data.size.getHeight());
                Circle circleThis = new Circle(getX(), getY(), getSize().getHeight());
                break;
        }

        if (rectangleThis.intersects(rectangle)) {
            System.out.println("должно было заблочить");
            block = true;
            setChanged();
        }
        else
            block = false;
    }

    public static boolean intersect(Rectangle r, Circle c)
    {
        double cx = Math.abs(c.getCenterX() - r.getX() - (r.getWidth()/2));
        double xDist = (r.getWidth()/2) + c.getRadius();
        if (cx > xDist)
            return false;
        double cy = Math.abs(c.getCenterY() - r.getY() - (r.getWidth()/2));
        double yDist = (r.getHeight()/2) + c.getRadius();
        if (cy > yDist)
            return false;
        if (cx <= (r.getWidth()/2) || cy <= (r.getHeight()/2))
            return true;
        double xCornerDist = cx - (r.getWidth()/2);
        double yCornerDist = cy - (r.getHeight()/2);
        double xCornerDistSq = xCornerDist * xCornerDist;
        double yCornerDistSq = yCornerDist * yCornerDist;
        double maxCornerDistSq = c.getRadius() * c.getRadius();
        return xCornerDistSq + yCornerDistSq <= maxCornerDistSq;
    }*/
}
