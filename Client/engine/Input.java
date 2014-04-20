// Объединяет кнопки клавы, мыши, и еще чтото в одну кучу.

package engine;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Input implements KeyListener, MouseListener, MouseMotionListener  {
	static ArrayList<Keys> pressedKeys = new ArrayList<Keys>();
	static HashMap<MouseButton, MouseInfo> pressedMouseButtons = new HashMap<MouseButton, MouseInfo>();
	static Point mousePosition = new Point();
	static Point dragPosition = new Point();
	static boolean isDragging = false;
	static HashMap<MouseButton, MouseInfo> clickQueue = new HashMap<MouseButton, MouseInfo>();
	
	public MouseInfo getMouseInfo(MouseButton button) {
		if (pressedMouseButtons.containsKey(button))
			return pressedMouseButtons.get(button);
		
		return null;
	}
	
	public static boolean isMouseDragging() {
		return isDragging;
	}
	
	public static Point getMouseDragPosition() {
		return dragPosition;
	}
	
	public static Point getMousePosition() {
		return mousePosition;
	}
	
	public static boolean isMouseDown(MouseButton button) {
		boolean press = pressedMouseButtons.containsKey(button);
		return press;
	}
	
	public static boolean isMouseUp(MouseButton button) {
		return !isMouseDown(button);
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<MouseButton, MouseInfo> getClickQueue() {
		HashMap<MouseButton, MouseInfo> queue = (HashMap<MouseButton, MouseInfo>) clickQueue.clone();
		clickQueue.clear();
		
		return queue;
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<MouseButton, MouseInfo> getPressedMouseButtons() {
		return (HashMap<MouseButton, MouseInfo>) pressedMouseButtons.clone();
	}
	
	public static boolean isKeyDown(Keys key) {
		return pressedKeys.contains(key);
	}
	
	public static boolean isKeyUp(Keys key) {
		return !isKeyDown(key);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Keys> getPressedKeys() {
		return (ArrayList<Keys>) pressedKeys.clone();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if (Keys.indexOf(key.getKeyCode()) == null) {
			return;
		}
		if (!pressedKeys.contains(Keys.indexOf(key.getKeyCode()))) {
			pressedKeys.add(Keys.indexOf(key.getKeyCode()));
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if (Keys.indexOf(key.getKeyCode()) == null) {
			return;
		}
		if (pressedKeys.contains(Keys.indexOf(key.getKeyCode()))) {
			pressedKeys.remove(Keys.indexOf(key.getKeyCode()));
		}
	}

	@Override
	public void keyTyped(KeyEvent key) {}
	
	@Override
	public void mouseClicked(MouseEvent mouse) {
		MouseInfo minfo = new MouseInfo();
		switch (mouse.getButton()) {
			case 1:
				minfo.setButton(MouseButton.LEFT);
				break;
			case 3:
				minfo.setButton(MouseButton.RIGHT);
				break;
			default:
				minfo.setButton(MouseButton.OTHER);
				break;
		}
		
		minfo.setX(mouse.getX());
		minfo.setY(mouse.getY());
		
		if (!clickQueue.containsKey(minfo.getButton())) {
			clickQueue.put(minfo.getButton(), minfo);
		}
	}

	@Override
	public void mouseEntered(MouseEvent mouse) {

	}

	@Override
	public void mouseExited(MouseEvent mouse) {

	}

	@Override
	public void mousePressed(MouseEvent mouse) {
		MouseInfo minfo = new MouseInfo();
		switch (mouse.getButton()) {
			case 1:
				minfo.setButton(MouseButton.LEFT);
				break;
			case 3:
				minfo.setButton(MouseButton.RIGHT);
				break;
			default:
				minfo.setButton(MouseButton.OTHER);
				break;
		}
		
		minfo.setX(mouse.getX());
		minfo.setY(mouse.getY());
		
		if (!pressedMouseButtons.containsKey(minfo.getButton())) {
			pressedMouseButtons.put(minfo.getButton(), minfo);
		}
	}

	@Override
	public void mouseReleased(MouseEvent mouse) {
		isDragging = false;
		MouseButton buttonToCheck = null;
		switch (mouse.getButton()) {
			case 1:
				buttonToCheck = MouseButton.LEFT;
				break;
			case 3:
				buttonToCheck = MouseButton.RIGHT;
				break;
		}
		
		if (buttonToCheck != null) {
			if (pressedMouseButtons.containsKey(buttonToCheck))
				pressedMouseButtons.remove(buttonToCheck);
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent mouse) {
		dragPosition.x = mouse.getX();
		dragPosition.y = mouse.getY();
		
		isDragging = true;
	}

	@Override
	public void mouseMoved(MouseEvent mouse) {
		mousePosition.x = mouse.getX();
		mousePosition.y = mouse.getY();
	}
}
