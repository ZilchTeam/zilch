package Server;

import java.awt.*;
import java.util.Observable;

public class NoLiveObject extends GameObject {
    public NoLiveObject(Point location, int size, Color color, String shape, Boolean pass) {
        super(location, size, color, shape, pass, null);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
