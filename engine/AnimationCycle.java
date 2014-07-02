package engine;// Анимация какаято. Ненужно пока.

/*
package engine;

public class AnimationCycle {
	int startFrame, endFrame;
	String name;
	int currentFrame;
	float timer = 0;
	
	public AnimationCycle(String name, int start, int end, float timer) {
		this.startFrame = this.currentFrame = start;
		this.endFrame = end;
		this.timer = timer;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	float timerStore = 0;
	public void update(float elapsedTime) {
		timerStore += elapsedTime;
		
		if (timerStore > timer) {
			currentFrame++;
			
			if (currentFrame > endFrame)
				currentFrame = startFrame;
			
			timerStore = 0;
		}
	}
	
	public int getFrame() {
		return currentFrame;
	}
}
*/