package com.linkui.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Planet extends Star {

	// Besides image, coordinate, planet has its orbit. x^2/a^2 + y^2/b^2 = 1;
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center;

	public Planet(String imgPath, double longAxis, double shortAxis, double speed, Star center) {
		super(GameUtil.getImage2(imgPath));
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;

		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;

	}

	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}

	public Planet(String path, double x, double y) {
		super(path, x, y);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		move();
		drawOrbit(g);
	}

	public void drawOrbit(Graphics g) {
		double ovalX, ovalY, ovalWidth, ovalHeight;

		// Calculate the coordinates
		ovalWidth = longAxis * 2;
		ovalHeight = shortAxis * 2;
		ovalX = (center.x + center.width / 2) - longAxis;
		ovalY = (center.y + center.height / 2) - shortAxis;

		// draw the Oval
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.drawOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
		g.setColor(c);

	}

	// Move as Oval orbit
	public void move() {
		x = (center.x + center.width / 2 + longAxis * Math.cos(degree)) - width / 2;
		y = (center.y + center.height / 2 + shortAxis * Math.sin(degree)) - height / 2;

		degree += speed;
	}

}
