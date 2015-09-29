package com.linkui.solar;

import java.awt.Graphics;
import java.awt.Image;

public class Star {
	Image img;

	// coordinates
	double x, y;
	int width, height;

	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
	}

	// empty constructor
	public Star() {
	}

	public Star(Image img) {
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		//System.out.println("sun: " + img.getWidth(null) + img.getWidth(null));
	}

	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;
		this.y = y;
	}

	// overload constructor
	public Star(String path, double x, double y) {
		this(GameUtil.getImage2(path), x, y);
	}

}
