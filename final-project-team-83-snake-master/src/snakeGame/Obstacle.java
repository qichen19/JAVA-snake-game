package snakeGame;
/**
 * @author Yunyang Li, Qi Chen, Xiaoge Fan
 * This Obstacle class contains methods which generates obstacles based on different levels
 */
import java.util.Random;

import javax.swing.ImageIcon;

public class Obstacle {
	int length; // length of vertical obstacles
	int obstacleX;	// x position of obstacle for level 1
	int[] obstacleY; // y position of obstacle of level 1
	int OX2; // x position of obstacle for level 2
	int [] OY2; // y position of obstacle for level 2
	int oX3; // x position of obstacle for level 3
	int oY3; // y position of obstacle for level 3
	ImageIcon obstacleImage; // image icon of obstacle
	Random random = new Random();
	/**
	 * constructor
	 * @param level
	 */
	public Obstacle(Level level) {	
		switch(level) {
		case LEVEL0:
			obstacleX = 0;
			obstacleY = null;
		case LEVEL1:
			addObstacle1();
		case LEVEL2:
			addObstacle2();
		case LEVEL3:
			addObstacle3();			
		}
		obstacleImage = drawObstacle(level);
	}
	/**
	 * generates obstacle x and y position for level 1
	 */
	public void addObstacle1() {
		length = 10;
		obstacleY = new int[length];
		obstacleX = 150;
		for(int i = 0; i < length; i++) {
			obstacleY[i] = 300 + 25*i;
		}	
	}
	/**
	 * generates obstacle x and y position for level 2
	 */
	public void addObstacle2() {
		length = 10;
		OY2 = new int[length];
		OX2 = 600;		
		for(int i = 0; i < length; i++) {
			OY2[i] = 300 + 25*i;
		}

	}
	/**
	 * generates obstacle x and y position for level 3
	 */
	public void addObstacle3() {
		oX3 = 25 + 25*random.nextInt(34);
		oY3 = 125;
	}
	
	/**
	 * returns image icon based on different levels
	 * @param level
	 * @return ImageIcon
	 */
	public ImageIcon drawObstacle(Level level) {
		if(level == Level.LEVEL0) {
			return null;
		}
		else if(level == Level.LEVEL1) {
			return Data.obstacle;
		}
		else if (level == Level.LEVEL2) {
			return Data.seaUrchin;
		} else if(level == Level.LEVEL3) {
			return Data.meteor2;
		}
		return null;		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getObstacleX() {
		return obstacleX;
	}
	public void setObstacleX(int obstacleX) {
		this.obstacleX = obstacleX;
	}
	public int[] getObstacleY() {
		return obstacleY;
	}
	public void setObstacleY(int[] obstacleY) {
		this.obstacleY = obstacleY;
	}
	public int getOX2() {
		return OX2;
	}
	public void setOX2(int oX2) {
		OX2 = oX2;
	}
	public int[] getOY2() {
		return OY2;
	}
	public void setOY2(int[] oY2) {
		OY2 = oY2;
	}
	public int getoX3() {
		return oX3;
	}
	public void setoX3(int oX3) {
		this.oX3 = oX3;
	}
	public int getoY3() {
		return oY3;
	}
	public void setoY3(int oY3) {
		this.oY3 = oY3;
	}
	public ImageIcon getObstacleImage() {
		return obstacleImage;
	}
	public void setObstacleImage(ImageIcon obstacleImage) {
		this.obstacleImage = obstacleImage;
	}

}
