package snakeGame;
/**
 *@author Yunyang Li, Qi Chen, Xiaoge Fan
 *This is the main design body of the snakeGame
 * This GamePanel class interacts with all the other classes
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
	private Snake snake;
	private Food food;
	private Score s;
	private String direction;  // string representing directions
	private boolean isStart; // boolean value representing weather the user starts the game or not
	private Level level;
	Timer timer;	
	private boolean isFail; // boolean value representing weather the user fails the game or not
	private Obstacle obstacle;
	int existingHighScore; // highest score
	int bombTimer; // time span of bomb in level 2
	/**
	 * constructor
	 * initializes the game, listens to the keyboard and sets a timer start. 
	 */
	public GamePanel() {
		level = Level.LEVEL0;
		play();
		existingHighScore = 0;
		bombTimer = 0;
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	/**
	 * initializes the snake game 
	 */
	public void play() {		
		snake = new Snake();
		snake.init();
		food = new Food(level);
		obstacle = new Obstacle(level);
		direction = "R";
		isStart = false;		
		isFail = false;
		s = new Score();	
		timer = new Timer(150, this);
		timer.start();
	}	
	/**
	 * paints essential components of the game
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //clears the window
		this.setBackground(Color.white); //sets background color to white
		Data.back.paintIcon(this, g, 0, 0); //paints the header picture

		paintBackground(g);
		paintSnake(g);
		paintFood(g);
		paintObstacle(g);
		paintScore(g);
		paintStartMenu(g);
		paintEndOfGame(g);
	}
	/**
	 * gets the key values
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();   
		//if the key is SPACE, start/pause the game
		if(keyCode == KeyEvent.VK_SPACE) {
			if(isFail()) {
				timer.stop();
				setFail(false); 
				setLevel(Level.LEVEL0); 			
				play();
			}else {
				setStart(!isStart());
			}		
			repaint();  			
		}

		//controls directions according to the key value. When the current direction is 
		// equal or opposite to the key value, ignores the key value
		if(getDirection()!= "L" && getDirection() != "R" && keyCode == KeyEvent.VK_RIGHT) {
			setDirection("R");
			Data.moveRightClip.play();
		}else if(getDirection() != "R" && getDirection() != "L" && keyCode == KeyEvent.VK_LEFT) {
			setDirection("L");
			Data.moveLeftClip.play();
		}else if(getDirection() != "D" && getDirection() != "U" && keyCode == KeyEvent.VK_UP) {
			setDirection("U");
			Data.moveUpClip.play();
		}else if(getDirection() != "U" && getDirection() != "D" && keyCode == KeyEvent.VK_DOWN) {
			setDirection("D");
			Data.moveDownClip.play();
		}
	}
	/**
	 * sets events based on the timer
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// if the game is not over, moves snake body and head	
		if(isStart&& isFail== false) {
			snake.moveSnakeBody();		
			snake.moveSnakeHead(getDirection()); 
			eat();
			endOfGame();
			updateLevel();
			repaint();  //refresh the window
		}
		timer.start();
	}
	/** helper method
	 * paints the background based on different levels
	 */
	private void paintBackground(Graphics g) {
		if(getLevel() == Level.LEVEL0) {			
			g.fillRoundRect(25, 150, 850, 525, 30, 30);
		}else if(getLevel() == Level.LEVEL1){ //paints the header picture
			Data.back.paintIcon(this, g, 0, 0); 
		} else if(getLevel() == Level.LEVEL2) {
			Data.back2.paintIcon(this, g, 0, 0);		
		} else if(getLevel() == Level.LEVEL3) {
			Data.back3.paintIcon(this, g, 0, 0);	
		}
		Color myC = new Color(0, 0, 0, 60);
		g.setColor(myC);
		g.fillRoundRect(25, 150, 850, 525, 30, 30);
	}
	/** helper method
	 * paints a snake
	 */	
	private void paintSnake(Graphics g) {
		// draws snake head based on different levels
		if(level == Level.LEVEL1||level == Level.LEVEL0||level == Level.LEVEL2) {
			snake.drawSnakeHead(direction).paintIcon(this, g, snake.getSnakeX()[0], snake.getSnakeY()[0]); 
		}else if(level == Level.LEVEL3) {
			snake.drawSnakeHead3(direction).paintIcon(this, g, snake.getSnakeX()[0], snake.getSnakeY()[0]);
		}

		//draws snake body, makes the body grow when the body length grow		
		for (int i = 1; i < snake.getLength(); i++) {
			snake.drawSnakeBody(level).paintIcon(this, g, snake.getSnakeX()[i], snake.getSnakeY()[i]);
		}
	}	
	/** helper method
	 * paints the food
	 */
	private void paintFood(Graphics g) {
		// paints bomb in level 2, makes bomb disappear when bombTimer > 50
		if(level == Level.LEVEL2 && food.getFoodImage() == Data.bomb) {
			bombTimer ++;
		}
		if (bombTimer >50) {
			food = new Food(level);
			bombTimer = 0;
		}

		// if food appears in the position of snake or obstacle, generates a new food
		for(int i = 0; i < snake.getLength(); i++) {
			while (food.getFoodX() == snake.getSnakeX()[i] && food.getFoodY() == snake.getSnakeY()[i]) {
				food = new Food(level);
			}
		}
		for(int j = 0; j < obstacle.length; j++) {
			while(food.getFoodX() == obstacle.obstacleX && food.getFoodY() == obstacle.obstacleY[j]) {		
				food = new Food(level);
			}				
		}
		for(int k = 0; k < getObstacle().length; k++) {
			while(food.getFoodX() == obstacle.OX2 && food.getFoodY() == obstacle.OY2[k]) {				
				food = new Food(level);
			}				
		}
		getFood().getFoodImage().paintIcon(this, g, food.getFoodX(), food.getFoodY());
	}	
	/** helper method
	 * paints the obstacles
	 */
	private void paintObstacle(Graphics g) {
		// paints static obstacles in level 1 and level 2
		if(level == Level.LEVEL1) {
			for(int i = 0; i < obstacle.length; i++) {
				obstacle.obstacleImage.paintIcon(this, g, obstacle.obstacleX, obstacle.obstacleY[i]);
			}
		}		
		if(level == Level.LEVEL2) {
			for(int i = 0; i < obstacle.length; i++) {
				obstacle.obstacleImage.paintIcon(this, g, obstacle.OX2, obstacle.OY2[i]);
			}		
		}

		// paints dynamic obstacle in level 3
		if(level == Level.LEVEL3) {				
			int i = 1;
			while(i >0) {
				obstacle.oY3 += 25;
				obstacle.obstacleImage.paintIcon(this, g, obstacle.oX3, obstacle.oY3);				
				i--;
			}
			if (obstacle.oY3>575) {
				obstacle = new Obstacle(level);
			}			
		}
	}	
	/** helper method
	 * paints the score and length based on different levels
	 */	
	private void paintScore(Graphics g) {
		g.setColor(Color.BLACK);  
		g.setFont(new Font("Ahoroni", Font.LAYOUT_LEFT_TO_RIGHT, 30));  
		//g.drawString("length:" + snake.length, 100, 35);
		g.drawString("score:" + getS().getScore(), 300, 35);
		g.drawString("High Score: " + getS().getMaxScore(), 300, 75);

		if(getLevel() == Level.LEVEL0) {
			g.drawString("Warming up...",300,115);
		}
		else if(getLevel() == Level.LEVEL1) {
			g.drawString("Level 1",300,115);
		}
		else if (getLevel() == Level.LEVEL2) {
			g.drawString("Level 2", 300, 115);
		}
		else if (getLevel() == Level.LEVEL3) {
			g.drawString("Level 3",300,115);
		}
	}	
	/** helper method
	 * paints the start prompt before the user starts the game
	 */
	private void paintStartMenu(Graphics g) {
		if(isStart() == false) {
			g.setColor(Color.WHITE);  
			g.setFont(new Font("Ahoroni", Font.BOLD, 40)); 
			g.drawString("Welcome to the world baby snake!", 150, 200);
			g.setFont(new Font("Ahoroni", Font.BOLD, 30));  
			g.drawString("(Yes, that's you, baby snake)", 150, 250);
			g.drawString("Survival is easy!", 150, 300);
			g.drawString("Just eat fruits, avoid bombs,", 150, 350);
			g.drawString("And don't run into walls!", 150, 400);
			g.drawString("Oh right, and don't try your luck on meteors.", 150, 450);
			g.drawString("Ready? Press space and lets go!", 150, 500);
		}	
	}	
	/** helper method
	 * paints the end of game prompt if the user fails the game
	 */
	private void paintEndOfGame(Graphics g) {
		if(isFail()) {
			g.setColor(Color.RED);
			g.setFont(new Font("Ahoroni", Font.BOLD, 40));  
			g.drawString("Game Over", 350, 200);
			if(getS().getMaxScore() > existingHighScore) {
				g.drawString("New High Score!", 300, 250);
			}
			g.setColor(Color.WHITE);
			g.setFont(new Font("Ahoroni", Font.BOLD, 30));
			g.drawString("You scored: " + getS().getScore() + "!", 50, 300);
			g.drawString("Press Space to start again", 50, 350);
			g.drawString("Or exit by closing the window", 50, 400);
		}
	}
	/** helper method
	 * eats food
	 * if the head is on food position, increments body length by 1, adds score, stores this score to maxScore
	 * and generates a new food
	 */
	public void eat() {
		if(snake.getSnakeX()[0] == food.getFoodX() && snake.getSnakeY()[0] == food.getFoodY()) {
			snake.addSnakeLength(level, food);
			s.addScore(level, food);
			if(food.getFoodImage() == Data.bomb) {
				Data.explodeClip.play();
			} else {
				Data.eatClip.play();			
			}
			if(s.getScore() > s.getMaxScore()) {
				s.setMaxScore(s.getScore());
			}

			// updates level based on new score
			if(s.getScore() >= 15) {
				level = Level.LEVEL3;
			}
			else if (getS().getScore() >=10) {
				level = Level.LEVEL2;
			}
			else if (getS().getScore() >=5) {
				level = Level.LEVEL1;
			}

			//generates a new food according to updated level
			food = new Food(level); 			
		}
	}
	/** helper method
	 * ends the game
	 * if the snake head touches its body, ends the game
	 * or the snake hits the boundary, ends the game
	 */
	public void endOfGame() {
		// if snake eats its body, ends the game
		for(int i = 1; i < snake.getLength(); i++) {
			if(snake.getSnakeX()[0] == snake.getSnakeX()[i] && snake.getSnakeY()[0] == snake.getSnakeY()[i]) {
				isFail = true;
			}
		}				
		// if snake hits the boundary, ends the game
		if(snake.snakeHitBoundary(direction)) {
			isFail = true;
		}
		// if snake hits the obstacle, ends the game
		if(level == Level.LEVEL1) {
			for(int i = 0; i <obstacle.length; i++) {
				if(snake.getSnakeX()[0] == obstacle.obstacleX && snake.getSnakeY()[0] == obstacle.obstacleY[i]) {
					isFail = true;
				}
			}
		} else if(level == Level.LEVEL2) {
			for(int i = 0; i < obstacle.length; i++) {
				if(snake.getSnakeX()[0] == obstacle.OX2 && snake.getSnakeY()[0] == obstacle.OY2[i]) {
					isFail = true;
				}
			}
		}
		else if(level == Level.LEVEL3) {
			for(int i = 1; i < snake.getLength(); i++) {
				if(snake.getSnakeX()[0] == obstacle.oX3 &snake.getSnakeY()[0] == obstacle.oY3) {					
					isFail = true;
				} else if(snake.getSnakeX()[i] == obstacle.oX3 && snake.getSnakeY()[i] == obstacle.oY3) {					
					snake.setLength(3);
					s.setScore(15);
				}
			}	
		}
		// if score is a negative number, ends the game
		if(s.getScore() <0) {
			isFail = true;
		}
		// if the game ends, plays the ending sound
		if(isFail() == true) {
			Data.endClip.play();
		}
		// if the game ends, snake decrements length by 1 (moves snake one step backwards)
		if(isFail == true) {
			for(int i = 0; i< getSnake().getLength()-1; i++) {
				snake.getSnakeX()[i] = snake.getSnakeX()[i+1];
				snake.getSnakeY()[i] = snake.getSnakeY()[i+1];
			}		
		}
	}	
	/** helper method
	 * updates level, sets new timer, updates obstacle image
	 */
	public void updateLevel() {
		if(s.getScore() >= 15) {
			level = Level.LEVEL3;
			timer.stop();
			timer = new Timer(100, this);
			obstacle.obstacleImage = Data.meteor2;

		}
		else if (s.getScore() >=10) {
			level = Level.LEVEL2;
			timer.stop();
			timer = new Timer(100, this);
			obstacle.obstacleImage = Data.seaUrchin;
		}
		else if (s.getScore() >= 5) {
			setLevel(Level.LEVEL1);
			timer.stop();
			timer = new Timer(120, this);
			obstacle.obstacleImage = Data.obstacle;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}
	public Obstacle getObstacle() {
		return obstacle;
	}
	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Score getS() {
		return s;
	}
	public void setS(Score s) {
		this.s = s;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public boolean isStart() {
		return isStart;
	}
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	public boolean isFail() {
		return isFail;
	}
	public void setFail(boolean isFail) {
		this.isFail = isFail;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}	
}
