package com.linkui.test;

import java.awt.Graphics;
import java.awt.Image;

/**
 * Pool ball (move to any direction)
 * 
 * @author Linkui
 *
 */
public class GameFrame04 extends MyFrame { // GUI programming

	Image img = GameUtil.getImage("images/whiteball.png");

	public static void main(String[] args) {
		new GameFrame04().launchFrame();
	}


	private double x = 100, y = 100;

	private double degree = Math.PI / 3; // [0,2pi], here is 60 degree
	
	private double speed = 10;

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, (int) x, (int) y, null);
		
		if(speed > 0){
			speed -= 0.05;
		}

		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		// Calculate reflected route
		if (y > Constant.GAME_HEIGHT - 50 || y < 30)
			degree = -degree;
		if (x > Constant.GAME_WIDTH - 50 || x < 0)
			degree = Math.PI - degree;
	}

}