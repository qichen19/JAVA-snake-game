package snakeGame;
/**
 * @author Yunyang Li, Qi Chen, Xiaoge Fan
 * This Score class calculates score
 */
public class Score {
	private int score; // current score
	private int maxScore; // highest score
	
	/**
	 * constructor
	 */
	public Score() {
		score = 0;
		maxScore = 0;
	}
	/**
	 * calculates score based on different levels and foods
	 * @param level
	 * @param food
	 */
	public void addScore(Level level, Food food) {
		if(level == Level.LEVEL0||level == Level.LEVEL1) {
			if(food.getFoodImage() == Data.apple) {
				score++; // eats an apple, score increments by 1
			} else if(food.getFoodImage() == Data.pear) {
				score+=2; // eats a pear, score increments by 2
			} else if(food.getFoodImage() == Data.peach) {
				score+=3; // eats a peach, score increments by 3
			} 
		}
		else if (level == Level.LEVEL2) {
			if(food.getFoodImage() == Data.shrimp) {
				score++; // eats a shrimp, score increments by 1
			} else if(food.getFoodImage() == Data.crab) {
				score+=2; // eats a crab, score increments by 2
			} else if (food.getFoodImage() == Data.bomb) {
				score-=2; // eats a bomb, score decrements by 2
			}
		}
		if(level == Level.LEVEL3) {
			if(food.getFoodImage() == Data.star) {
				score+=3; // eats a star, score increments by 3
			}
		}			
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
}
