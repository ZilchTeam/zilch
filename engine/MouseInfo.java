// Непонятно.

package engine;

public class MouseInfo extends Positionable {
	MouseButton button;
	
	public MouseInfo() {}
	
	public void setButton(MouseButton button) {
		this.button = button;
	}
	
	public MouseButton getButton() {
		return button;
	}
}
