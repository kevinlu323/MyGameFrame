package com.linkui.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Object move on Horizontal or Vertical direction
 * 
 * @author Linkui
 *
 */
public class GameFrame02 extends Frame { // GUI programming

	Image img = GameUtil.getImage("images/sun-small.png");

	public static void main(String[] args) {
		new GameFrame02().launchFrame();
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
	private boolean left;

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, (int) x, (int) y, null);

		if (left) {
			x -= 10;
		} else {
			x += 10;
		}

		if (x > 400 - 50) {
			left = true;
		}
		if (x < 0) {
			left = false;
		}
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
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}