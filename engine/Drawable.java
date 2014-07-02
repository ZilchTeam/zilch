// Тут все понятоно кроме elapsedTime

package engine;

import java.awt.*;
import java.rmi.RemoteException;

public interface Drawable {
	public void update(float elapsedTime) throws RemoteException;
	public void draw(Graphics g, float elapsedTime) throws RemoteException;
}
