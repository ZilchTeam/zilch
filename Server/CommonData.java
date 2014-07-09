package Server;

import java.awt.*;

public class CommonData {

    Point location; //Положение
    int size; //Размер
    String objName;
    String shape;
    public CommonData(Point location, int size, String objName, String shape){
        this.location = location;
        this.size = size;
        this.objName = objName;
        this.shape = shape;
    }
}
