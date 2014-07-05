package Server;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameObjectsFactory extends AbstractFactory {
    public ArrayList<Player>       players = new ArrayList<Player>();           //список игроков
    public ArrayList<LivingObject> livingObjs = new ArrayList<LivingObject>();  //список живых объектов
    public ArrayList<NoLiveObject> noLifeObjs = new ArrayList<NoLiveObject>();  //список не живых объектов
    private Random random = new Random();

    @Override
    public GameObject getGameObj(String objName) {
        if (objName != null ) {
            return new Player(new Point(random.nextInt(500), random.nextInt(500)), 1, Color.red, "quad", true, 1, objName);
        }
        return null;
    }

    public GameObject getGameObj(String objName, boolean live) {
        if (live) {
            return new LivingObject(new Point(random.nextInt(500), random.nextInt(500)), 1, Color.CYAN, "Quad", true, objName, 5 );
        }
        else {
            return new NoLiveObject(new Point(random.nextInt(500), random.nextInt(500)), 1, Color.CYAN, "Quad", true );
        }
    }
}
