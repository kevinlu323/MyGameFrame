package com.linkui.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * Pool ball (move to any direction)
 * 
 * @author Linkui
 *
 */
public class GameFrame05 extends MyFrame { // GUI programming

	Image img = GameUtil.getImage("images/whiteball.png");
	
	private double ballX = 160, ballY = 250;

	private double degree = Math.PI / 3; // [0,2pi], here is 60 degree
	
	private double speed = 0;
	
	public static void main(String[] args) {
		new GameFrame05().launchFrame();
	}

	@Override
	public void launchFrame() {
		super.launchFrame();
		this.setBackground(Color.GRAY);
		this.addMouseListener(new MyMouseMonitor());
		
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		//g.drawImage(img, (int) ballX, (int) ballY, null);
		g.fillOval((int)ballX, (int)ballY, 50, 50);
		g.setColor(c);
		if(speed > 0){
			speed -= 0.1;
		}else{
			speed = 0;
		}

		ballX += speed * Math.cos(degree);
		ballY += speed * Math.sin(degree);

		// Calculate reflected route
		if (ballY > Constant.GAME_HEIGHT - 50 || ballY < 30)
			degree = -degree;
		if (ballX > Constant.GAME_WIDTH - 50 || ballX < 0)
			degree = Math.PI - degree;
	}
	
	class MyMouseMonitor extends MouseAdapter{
		
		double mouseX, mouseY;
		
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Mouse point: " + e.getX());
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			if(speed <= 0){
				speed = 15;
				
				//use ball center point, which is (ballX+25,ballY+25)
				if(mouseX <(ballX+25)){
					degree = Math.atan((mouseY - (ballY+25)) / (mouseX - (ballX+25))) % (2 *Math.PI);
				}
				else if(mouseX > (ballX+25)){
					degree = Math.PI + Math.atan((mouseY - (ballY+25)) / (mouseX - (ballX+25))) % (2 *Math.PI);
				}
				//System.out.println("new degree: " + degree);
				
			}
		}
		
		
		
	}
}