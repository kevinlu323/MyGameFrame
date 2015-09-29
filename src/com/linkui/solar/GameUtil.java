package com.linkui.solar;

import java.awt.Image;
import java.awt.Toolkit;


/**
 * Common tool Class (like loading images)
 * @author Linkui
 *
 */
public class GameUtil {
	
	private GameUtil(){}
	
	public static Image getImage(String path){
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
