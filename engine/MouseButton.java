package engine;

public enum MouseButton {
	LEFT(1),
	RIGHT(3),
	OTHER(2);
	
	private int index;
	MouseButton(int index) {
		this.index = index;
	}
	
	public int get() {
		return index;
	}
}
