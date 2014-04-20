// Тут все понятоно кроме elapsedTime

package engine;

import java.awt.Graphics;

public interface Drawable {
	public void update(float elapsedTime);
	public void draw(Graphics g, float elapsedTime);
}
