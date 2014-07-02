// Эта штука может открыть нельскоко портов просмотра и переключатся между ними.
// Штука интересная, но ненужная, по крйней мере сейчас.

package engine;

import java.awt.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class StateManager {
	ArrayList<GameState> gameStates = new ArrayList<GameState>();
	GameState currentState;
	Camera camera = new Camera();
	
	public static StateManager instance;
	
	public StateManager() {	}
	
	public static StateManager getInstance() {
		if (instance == null)
			instance = new StateManager();
		
		return instance;
	}
	
	public void addState(GameState state) {
		if (!gameStates.contains(state))
			gameStates.add(state);
		
		if (currentState == null)
			currentState = gameStates.get(0);
	}
	
	public void switchState(GameState state) {
		this.currentState.dispose();
		this.currentState = state;
	}
	
	public void Update(float elapsedTime) throws RemoteException {
        try {
            currentState.update(elapsedTime);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
	
	public void Draw(Graphics g, float elapsedTime) {
		if (currentState != null)
            try {
                currentState.draw(g, elapsedTime);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
    }
	
	public Camera getCamera() {
		return camera;
	}
}
