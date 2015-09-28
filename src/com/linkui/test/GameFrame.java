package com.linkui.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Game Frame Class
 * 
 * @author Linkui
 *
 */
public class GameFrame extends Frame { // GUI programming

	Image img = GameUtil.getImage("images/sun-small.png");

	public static void main(String[] args) {
		new GameFrame().launchFrame();
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

	@Override
	public void paint(Graphics g) {
		// Save previous color
		Color c = g.getColor();
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);

		Font f = new Font("Aharoni", Font.BOLD, 15);
		g.setFont(f);
		g.drawString("This is a String", 200, 200);

		g.fillRect(100, 100, 20, 20);

		g.setColor(Color.RED);
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);

		g.drawImage(img, (int) x, (int) y, null);

		x += 3;
		y += 3;
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
