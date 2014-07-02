package Server;

import ISend.ISend;
import engine.Keys;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ISend {

    private ControlPanel controlPanel;

    //конструктор
	public Server() throws RemoteException {
		//серверная часть
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
    public ArrayList<Player> getList() throws RemoteException {
        return controlPanel.players;//вернуть список игроков
    }

    @Override
    public void setPressedKeys(ArrayList<Keys> pressedKeys, int id) throws RemoteException {
        controlPanel.players.get(id).Move(pressedKeys);//записать нажатые клавиши игрока в объект данного игрока
    }

    public static void main(String[] args) throws RemoteException  {
		new Server();
		System.out.print("lol");
	}
}
