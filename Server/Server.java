package Server;

import ISend.ISend;
import engine.Keys;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ISend {

    private ControlPanel controlPanel;              //управляющее окно сервера(пока нет реализации)
    private GameObjectsFactory gameObjectsFactory;  //фабрика

    //конструктор
	public Server() throws RemoteException {

	    try {
            // create on port 1099
	        Registry registry = LocateRegistry.createRegistry(1099);
	        // create a new service named myMessage
	        registry.rebind("myMessage", this);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        //создаём фабрику
        gameObjectsFactory = new GameObjectsFactory();
        gameObjectsFactory.noLifeObjs.add((NoLiveObject)gameObjectsFactory.getGameObj("Name", false));

        //создаём управляющее окно
	    controlPanel = new ControlPanel();
	}

    //переопределяем метод интерфейса ISend возвращающий список всех игровых объектов
    @Override
    public ArrayList<GameObject> getList() throws RemoteException {
        //пихаем всё в один список
        //todo не эффективно , оптимизировать
        ArrayList<GameObject> list = new ArrayList<GameObject>();
        for (int i = 0; i < gameObjectsFactory.players.size(); i++) {
            GameObject obj = gameObjectsFactory.players.get(i);
            list.add(obj);
        }
        for (int i = 0; i < gameObjectsFactory.noLifeObjs.size(); i++) {
            GameObject obj = gameObjectsFactory.noLifeObjs.get(i);
            list.add(obj);
        }
        for (int i = 0; i < gameObjectsFactory.livingObjs.size(); i++) {
            GameObject obj = gameObjectsFactory.livingObjs.get(i);
            list.add(obj);
        }
        return list;
    }

    //переопределяем метод интерфейса ISend принимающий список нажатых клавиш нажатых пользователем-id
    @Override
    public void setPressedKeys(ArrayList<Keys> pressedKeys, int id) throws RemoteException {
        gameObjectsFactory.players.get(id).Move(pressedKeys);
    }

    //переопределяем метод интерфейса ISend регестрирующий нового игрока и возвращающий его id
    @Override
    public int addPlayer(String name) throws RemoteException {
        gameObjectsFactory.players.add((Player)gameObjectsFactory.getGameObj(name));
        return Player.playersCount - 1;
    }

    public static void main(String[] args) throws RemoteException  {
		new Server();
	}
}
