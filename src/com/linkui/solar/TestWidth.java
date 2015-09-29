package com.linkui.solar;

import java.awt.Image;

public class TestWidth {
	public static void main(String[] args) {
		Image img = GameUtil.getImage("images/whiteball.png");
		System.out.println(img.getWidth(null) + " , " + img.getHeight(null));
	}
}
