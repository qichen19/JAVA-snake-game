package snakeGame;
/**
 * @author Yunyang Li, Qi Chen, Xiaoge Fan
 * This Food class contains methods which generates foods based on different levels
 */
import java.util.Random;

import javax.swing.ImageIcon;

public class Food {
	private int foodX; // x position of food
	private int foodY; // y position of food
	private ImageIcon foodImage; // image icon of food
	Random random = new Random();

	/**
	 * constructor
	 */
	public Food(Level level) {
		setFoodX(25 + 25*random.nextInt(34));
		foodY = 150 + 25*random.nextInt(19);
		setFoodImage(drawFood(level));
	}
	
	/**
	 * returns ImageIcon of foods based on different levels
	 * @param level
	 * @return ImageIcon
	 */
	public ImageIcon drawFood(Level level) {
		switch(level) {
		case LEVEL0:
			return randomFoodGenerator0();
		case LEVEL1: 
			return randomFoodGenerator1();
		case LEVEL2: 
			return randomFoodGenerator2();
		case LEVEL3: 
			return randomFoodGenerator3();
		default:
			return null;
		}		
	}
	/**
	 * generates food for level 0
	 * @return ImageIcon
	 */
	public ImageIcon randomFoodGenerator0() {
		return Data.apple;
	}
	/**
	 * generates food for level 1
	 * @return ImageIcon
	 */
	public ImageIcon randomFoodGenerator1() {
		int foodNumber = 1;
		foodNumber = 1 + random.nextInt(3);
		switch(foodNumber) {
		case 1:
			return Data.apple;
		case 2: 
			return Data.pear;
		case 3: 
			return Data.peach;
		default:
			return null;				
		}		
	}
	
	/**
	 * generates food for level 2
	 * @return ImageIcon
	 */
	public ImageIcon randomFoodGenerator2() {
		int foodNumber = random.nextInt(3);
		switch(foodNumber) {
		case 0:
			return Data.bomb;
		case 1: 
			return Data.shrimp;
		case 2:
			return Data.crab;
		default:
			return null;				
		}		
	}
	
	/**
	 * generates food for level 3
	 * @return ImageIcon
	 */
	public ImageIcon randomFoodGenerator3() {
		return Data.star;	
	}

	public int getFoodX() {
		return foodX;
	}

	public void setFoodX(int foodX) {
		this.foodX = foodX;
	}

	public int getFoodY() {
		return foodY;
	}

	public void setFoodY(int foodY) {
		this.foodY = foodY;
	}

	public ImageIcon getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(ImageIcon foodImage) {
		this.foodImage = foodImage;
	}
	
	
}
