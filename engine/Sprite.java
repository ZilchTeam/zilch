package engine;// Ненужно

/*
package engine;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class Sprite extends Image {
	HashMap<String, AnimationCycle> animations = new HashMap<String, AnimationCycle>();
	AnimationCycle currentCycle = null;
	int frames, widthOfFrames, heightOfFrames;
	
	public Sprite(String fileName, int frames, int widthOfFrame, int heightOfFrame) throws IOException {
		super(fileName);
		this.frames = frames;
		this.widthOfFrames = widthOfFrame;
		this.heightOfFrames = heightOfFrame;
	}
	
	public void update(float elapsedTime) {
		if (currentCycle != null) {
			currentCycle.update(elapsedTime);
		}
	}
	
	public void setAnimationCycle(String name) {
		this.currentCycle = getCycle(name);
	}
	
	public String getCycleName() {
		return currentCycle.getName();
	}
	
	public AnimationCycle getCycle(String name) {
		return animations.get(name);
	}
	
	public void addCycle(String name, int startFrame, int endFrame, int timer) {
		AnimationCycle cycle = new AnimationCycle(name, startFrame, endFrame, timer);
		
		animations.put(name, cycle);
		
		if (currentCycle == null)
			this.currentCycle = cycle;
	}
	
	public BufferedImage getFrame() {
		return Util.cropImage(this.get(), new Rectangle(currentCycle.getFrame() * widthOfFrames, 0, widthOfFrames, heightOfFrames));
	}
	
	BufferedImage cachedFlip = null;
	public BufferedImage getFlipped() {
		BufferedImage frame = getFrame();
		
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-frame.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return op.filter(frame, null);

	}
}
*/
