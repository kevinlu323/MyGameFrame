package com.linkui.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Main window for solar System
 * 
 * @author linkui
 *
 */
public class SolarFrame extends MyFrame {
	Image offScreenImage = null;
	Image bg = GameUtil.getImage("images/bg.jpg");

	Star sun = new Star("images/Sun.jpg", Constant.GAME_WIDTH / 2 - 25, Constant.GAME_HEIGHT / 2 - 25);
	Planet earth = new Planet("images/Earth.jpg", 150, 100, 0.1, sun);

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
	}

	@Override
	public void update(Graphics g) { // double buffer to avoid blinking
		if (offScreenImage == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLUE);
		gOffScreen.drawImage(bg, 0, 0, null);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
