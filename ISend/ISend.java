package ISend;

import Server.BaseClass;
import Server.Player;
import engine.Keys;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ISend extends Remote {
    ArrayList<BaseClass> getList() throws RemoteException;
    void setPressedKeys(ArrayList<Keys> pressedKeys, int id) throws RemoteException;
    int addPlayer(String name) throws RemoteException;
}