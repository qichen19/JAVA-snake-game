package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import snakeGame.Data;
import snakeGame.Food;
import snakeGame.Level;
import snakeGame.Score;
import snakeGame.Snake;

class ScoreTest {

	@Test
	void testAddScoreLevel1() {
		Score s = new Score();
		Food f = new Food(Level.LEVEL1);
		int formerS = s.getScore();
		s.addScore(Level.LEVEL1, f);
		int newS = s.getScore();
		if(f.getFoodImage() == Data.apple) {
			assertEquals(newS, formerS + 1);
		} else if(f.getFoodImage() == Data.pear) {
			assertEquals(newS, formerS + 2);
		} else if(f.getFoodImage() == Data.peach) {
			assertEquals(newS, formerS + 3);
		}
	}
	
	
	@Test
	void testAddScoreLevel2() {
		Score s = new Score();
		Food f = new Food(Level.LEVEL2);
		int formerS = s.getScore();
		s.addScore(Level.LEVEL2, f);
		int newS = s.getScore();
		if(f.getFoodImage() == Data.shrimp) {
			assertEquals(newS, formerS + 1);
		} else if(f.getFoodImage() == Data.crab) {
			assertEquals(newS, formerS + 2);
		} else if(f.getFoodImage() == Data.bomb) {
			assertEquals(newS, formerS - 2);
		}
	}
	
	@Test
	void testAddScoreLevel0and3() {
		Score s = new Score();
		Food f = new Food(Level.LEVEL0);
		int formerS = s.getScore();
		s.addScore(Level.LEVEL0, f);
		int newS = s.getScore();
		assertEquals(newS, formerS + 1);
		
	    s = new Score();
		f = new Food(Level.LEVEL3);
		formerS = s.getScore();
		s.addScore(Level.LEVEL3, f);
		newS = s.getScore();
		assertEquals(newS, formerS + 3);
	}
}
