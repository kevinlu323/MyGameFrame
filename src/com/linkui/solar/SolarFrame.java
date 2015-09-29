package com.linkui.solar;

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
	Planet mecury = new Planet("images/Mercury.png", 100, 80, 0.08, sun, "Mercury");
	Planet venus = new Planet("images/Venus.png", 150, 110, 0.06, sun, "Venus");
	Planet earth = new Planet("images/Earth.jpg", 200, 140, 0.05, sun, "Earth");
	Planet mars = new Planet("images/Mars.png", 250, 170, 0.04, sun, "Mars");
	Planet jupiter = new Planet("images/Jupiter.png", 300, 210, 0.03, sun, "Jupiter");
	Planet saturn = new Planet("images/Saturn.png", 350, 250, 0.02, sun, "Saturn");
	Planet uranus = new Planet("images/Uranus.png", 400, 290, 0.01, sun, "Uranus");
	Planet neptune = new Planet("images/Neptune.png", 450, 330, 0.005, sun, "Neptune");

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		mecury.draw(g);
		venus.draw(g);
		earth.draw(g);
		mars.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		neptune.draw(g);
	}

	@Override
	public void update(Graphics g) { // double buffer to avoid blinking
		if (offScreenImage == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		gOffScreen.drawImage(bg, 0, 0, null);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
