package com.linkui.solar;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Common tool Class (like loading images)
 * 
 * @author Linkui
 *
 */
public class GameUtil {

	private GameUtil() {
	}

	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}

	public static Image getImage2(String path) {
		InputStream imgIS = GameUtil.class.getClassLoader().getResourceAsStream(path);
		Image img = null;
		try {
			img = ImageIO.read(imgIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
