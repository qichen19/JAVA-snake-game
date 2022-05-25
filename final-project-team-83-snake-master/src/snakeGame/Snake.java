package snakeGame;
/**
 * @author Yunyang Li, Qi Chen, Xiaoge Fan
 * This snake class contains methods which generates snake, makes the snake head and body move accordingly
 */
import javax.swing.ImageIcon;

public class Snake {
	private int length; // length of snake
	private int[] snakeX; // an array of x positions of the snake
	private int[] snakeY; // an array of y positions of the snake
	Level level;
	/**
	 * constructor
	 */
	public Snake(){
		setSnakeX(new int[600]);
		setSnakeY(new int[500]);		
	}
	
	/**
	 * initializes the very first snake with length 3
	 */
	public void init() {
		length = 3;
		snakeX[0] = 100; 
		snakeY[0] = 150;   //the position of the snake's head
		snakeX[1] = 75; 
		snakeY[1] = 150;   //the position of the snake's first body part
		snakeX[2] = 50; 
		snakeY[2] = 150;   //the position of the snake's second body part
	}
	/**
	 * returns ImageIcon of snake head for level 1 according to the given direction
	 * @param direction: a String corresponds to snake head direction, "L" means left, "R" means right, 
	 * "U" means up and "D" means down
	 * @return ImageIcon
	 */
	public ImageIcon drawSnakeHead(String direction) {		
			if(direction.equals("R")) {
				return Data.right;
			}else if(direction.equals("L")) {
				return Data.left;
			}else if(direction.equals("U")) {
				return Data.up;
			}else {
				return Data.down;
			}
	
	}
	/**
	 * returns ImageIcon of snake head for level 3 according to the given direction
	 * @param direction: a String corresponds to snake head direction, "L" means left, "R" means right, 
	 * "U" means up and "D" means down
	 * @return ImageIcon
	 */	
	public ImageIcon drawSnakeHead3(String direction) {
		if(direction.equals("R")) {
			return Data.right3;
		}else if(direction.equals("L")) {
			return Data.left3;
		}else if(direction.equals("U")) {
			return Data.up3;
		}else {
			return Data.down3;
		}
	}

	/**
	 * returns image icon of snake body based on levels
	 * @param level
	 * @return ImageIcon
	 */
	public ImageIcon drawSnakeBody(Level level) {
		switch(level) {
		case LEVEL0:
			return Data.body;
		case LEVEL1: 
			return Data.body;
		case LEVEL2:
			return Data.body;
		case LEVEL3: 
			return Data.body3;
		default:
			return null;
		}
		
	}
	/*
	 * moves the snake body based on the fact that when snake moves, 
	 * the current position always follows the previous position
	 */
	public void moveSnakeBody() {
		for (int i = getLength()-1; i>0; i--) { 
			snakeX[i] = snakeX[i - 1];
			snakeY[i] = snakeY[i - 1];
		}
	}
	/**
	 * moves the snake head according to the given directions
	 * @param direction
	 */	
	public void moveSnakeHead(String direction) {
		if(direction.equals("R")) {
			snakeX[0] = snakeX[0] + 25;  //move the head

		}else if(direction.equals("L")) {
			snakeX[0] = snakeX[0] - 25;  //move the head

		}else if(direction.equals("U")) {
			snakeY[0] = snakeY[0] - 25;  //move the head

		}else if(direction.equals("D")) {
			snakeY[0] = snakeY[0] + 25;  //move the head
		}		
	}
	/**
	 * returns true if snake hits the boundary
	 * @param direction
	 * @return a boolean variable showing weather the snake head hits the boundary or not
	 */
	
	public boolean snakeHitBoundary(String direction) {
		if(direction.equals("R") && getSnakeX()[0]>850) {
			return true;
		} else if(direction.equals("L") && getSnakeX()[0]<25 ) {
			return true;
		} else if(direction.equals("U") && getSnakeY()[0]<150) {
			return true;
		} else if (direction.equals("D") && getSnakeY()[0]>650) {
			return true;
		}
		return false;
	}
	/**
	 * adds the length of snakes based on different levels and foods
	 * @param level
	 * @param food
	 */
	public void addSnakeLength(Level level, Food food) {
		if(level == Level.LEVEL0||level == Level.LEVEL1) {
			if(food.getFoodImage() == Data.apple) {
				length++; // eats an apple, length increments by 1
			} else if(food.getFoodImage() == Data.pear) {
				length+=2; // eats a pear, length increments by 2
			} else if(food.getFoodImage() == Data.peach) {
				length+=3; // eats a peach, length increments by 3
			} 
		}

		else if(level == Level.LEVEL2) {
			if(food.getFoodImage() == Data.shrimp) {
				length++; //eats a shrimp, length increments by 1
			} else if(food.getFoodImage() == Data.crab) {
				length+=2; // eats a crab, length increments by 2
			} else if(food.getFoodImage() == Data.bomb) {
				length-=2; // eats a bomb, length decrements by 2
			}
		}
		
		else if(level == Level.LEVEL3) {
			if(food.getFoodImage() == Data.star) {
				length++; // eats a star, length increments by 1
			}
		}		
	}

	public int[] getSnakeX() {
		return snakeX;
	}

	public void setSnakeX(int[] snakeX) {
		this.snakeX = snakeX;
	}

	public int[] getSnakeY() {
		return snakeY;
	}

	public void setSnakeY(int[] snakeY) {
		this.snakeY = snakeY;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}	
}
