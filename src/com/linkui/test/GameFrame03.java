package com.linkui.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Pool ball (move to any direction)
 * 
 * @author Linkui
 *
 */
public class GameFrame03 extends Frame { // GUI programming

	Image img = GameUtil.getImage("images/whiteball.png");

	public static void main(String[] args) {
		new GameFrame03().launchFrame();
	}

	public void launchFrame() {
		setSize(400, 400);
		setLocation(300, 300);
		setVisible(true);

		new PaintThread().start();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private double x = 100, y = 100;

	private double degree = Math.PI / 3; // [0,2pi], here is 60 degree

	private double speed = 10;

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, (int) x, (int) y, null);

		if (speed > 0) {
			speed -= 0.05;
		}

		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		// Calculate reflected route
		if (y > 400 - 50 || y < 30)
			degree = -degree;
		if (x > 400 - 50 || x < 0)
			degree = Math.PI - degree;
	}

	/**
	 * Inner Thread to repaint window.
	 * 
	 * @author Linkui
	 *
	 */
	class PaintThread extends Thread {
		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}