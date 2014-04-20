// Описывает весь контент игры: картинки, музычка.
// 

package engine;


/*
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import kuusisto.tinysound.Music;

public class Content {
	public static Content instance;
	public static final String ROOT_FOLDER = "assets";
	
	private Map<String, Image> images = new HashMap<String, Image>();
	public Content() {}
	
	public static Content getInstance() {
		if (instance == null)
			instance = new Content();
		
		return instance;
	}
	
	public Image loadImage(String assetName) {
		if (images.containsKey(assetName)) return images.get(assetName);
		
		try {
			Image img = new Image("assets\\graphics\\" + assetName + ".png");
			images.put(assetName, img);
			
			return img;
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		return null;
	}
	
	public Sprite getSprite(String assetName) {
		return (Sprite) images.get(assetName);
	}
	
	public Sprite loadSprite(String assetName, int frames, int widthOfFrame, int heightOfFrame) {
		if (images.containsKey(assetName)) return getSprite(assetName);
		
		try {
			Sprite img = new Sprite("assets\\graphics\\" + assetName + ".png", frames, widthOfFrame, heightOfFrame);
			images.put(assetName, img);
			
			return img;
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		return null;
	}
	
	HashMap<String, Music> musicfiles = new HashMap<String, Music>();
	public Music loadMusic(String fileName) {
		if (musicfiles.containsKey(fileName)) return musicfiles.get(fileName);
		
		
		Music music = GameSound.loadMusic("assets\\audio\\"+ fileName +".ogg");
		musicfiles.put(fileName, music);
		return music;
	}
	
	public void unloadMusic() {
		for (Music m : musicfiles.values()) {
			m.unload();
		}
		
		musicfiles.clear();
	}
}

*/