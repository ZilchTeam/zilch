// Просто картинка у которой удобно сделано получение размеров.
// Еще ей можно задать имя. Также есть обработчики исключений.

package engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
	private String name;
	private BufferedImage image;
	private Dimension size;

	public Image(String fileName) throws IOException {
		this.name = fileName;
		this.image = ImageIO.read(new File(fileName));
		this.size = new Dimension(this.getWidth(), this.getHeight());
	}

	public BufferedImage get() {
		return image;
	}

	public String getName() {
		return name;
	}

	public Dimension getSize() {
		return size;
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getWidth() {
		return image.getWidth();
	}
}
