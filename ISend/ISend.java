package ISend;

import Server.Player;
import engine.Keys;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ISend extends Remote {
    ArrayList<Player> getList() throws RemoteException;
    void setPressedKeys(ArrayList<Keys> pressedKeys, int id) throws RemoteException;
}