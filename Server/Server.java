package Server;

import ISend.ISend;
import engine.Keys;

import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class Server extends UnicastRemoteObject implements ISend {

    private ControlPanel controlPanel;

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

	    controlPanel = new ControlPanel();
	}

    @Override
    public ArrayList<BaseClass> getList() throws RemoteException {
        //пихаем всё в один список
        //todo не эффективно , оптимизировать
        ArrayList<BaseClass> list = new ArrayList<BaseClass>();
        for (int i = 0; i < controlPanel.players.size(); i++) {
            BaseClass obj = controlPanel.players.get(i);
            list.add(obj);
        }
        for (int i = 0; i < controlPanel.noLifeObjs.size(); i++) {
            BaseClass obj = controlPanel.noLifeObjs.get(i);
            list.add(obj);
        }
        for (int i = 0; i < controlPanel.livingObjs.size(); i++) {
            BaseClass obj = controlPanel.livingObjs.get(i);
            list.add(obj);
        }
        return list;
    }

    @Override
    public void setPressedKeys(ArrayList<Keys> pressedKeys, int id) throws RemoteException {
        controlPanel.players.get(id).Move(pressedKeys);
    }

    @Override
    public int addPlayer(String name) throws RemoteException {
        Random random = new Random();
        //todo: перенести создание объектов на фабрику
        controlPanel.players.add(new Player(new Point(random.nextInt(500), random.nextInt(500)), 1, Color.red, "quad", true, 3, name));
        return Player.playersCount - 1;
    }

    public static void main(String[] args) throws RemoteException  {
		new Server();
	}
}
