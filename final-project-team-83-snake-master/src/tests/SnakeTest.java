package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import snakeGame.Data;
import snakeGame.Food;
import snakeGame.Level;
import snakeGame.Snake;

class SnakeTest {

	@Test
	void testMoveSnakeBody() {
		Snake s = new Snake();
		s.init();
		int formerX = s.getSnakeX()[0];
		int formerY = s.getSnakeY()[0];
		s.moveSnakeBody();
		assertEquals(s.getSnakeX()[1], formerX);
		assertEquals(s.getSnakeY()[1], formerY);
	}
	
	@Test
	void testMoveSnakeHead() {
		Snake s = new Snake();
		s.init();
		
		int formerX = s.getSnakeX()[0];
		int formerY = s.getSnakeY()[0];
		s.moveSnakeHead("R");
		assertEquals(s.getSnakeX()[0], formerX + 25);
		assertEquals(s.getSnakeY()[0], formerY );
		
		formerX = s.getSnakeX()[0];
		formerY = s.getSnakeY()[0];
		s.moveSnakeHead("L");
		assertEquals(s.getSnakeX()[0], formerX - 25);
		assertEquals(s.getSnakeY()[0], formerY);
		
		formerX = s.getSnakeX()[0];
		formerY = s.getSnakeY()[0];
		s.moveSnakeHead("D");
		assertEquals(s.getSnakeX()[0], formerX);
		assertEquals(s.getSnakeY()[0], formerY + 25);	
	}
	
	@Test
	void testSnakeHitBoundry() {
		Snake s = new Snake();
		s.getSnakeX()[0] = 851;
		assertTrue(s.snakeHitBoundary("R"));	
		
		s.getSnakeX()[0] = 24;
		assertTrue(s.snakeHitBoundary("L"));
		
		s.getSnakeY()[0] = 149;
		assertTrue(s.snakeHitBoundary("U"));
		
		s.getSnakeY()[0] = 651;
		assertTrue(s.snakeHitBoundary("D"));
	}
	
	@Test
	void testAddSnakeLengthLevel1() {
		Snake s = new Snake();
		Food f = new Food(Level.LEVEL1);
		int formerL = s.getLength();
		s.addSnakeLength(Level.LEVEL1, f);
		int newL = s.getLength();
		if(f.getFoodImage() == Data.apple) {
			assertEquals(newL, formerL + 1);
		} else if(f.getFoodImage() == Data.pear) {
			assertEquals(newL, formerL + 2);
		} else if(f.getFoodImage() == Data.peach) {
			assertEquals(newL, formerL + 3);
		}
	}
	
	@Test
	void testAddSnakeLengthLevel2 () {
		Snake s = new Snake();
		Food f = new Food(Level.LEVEL2);
		int formerL = s.getLength();
		s.addSnakeLength(Level.LEVEL2, f);
		int newL = s.getLength();
		if(f.getFoodImage() == Data.shrimp) {
			assertEquals(newL, formerL + 1);
		} else if(f.getFoodImage() == Data.crab) {
			assertEquals(newL, formerL + 2);
		} else if(f.getFoodImage() == Data.bomb) {
			assertEquals(newL, formerL - 2);
		}
	}
	
	@Test
	void testAddSnakeLengthLevel0and3() {
		Snake s = new Snake();
		Food f = new Food(Level.LEVEL0);
		int formerL = s.getLength();
		s.addSnakeLength(Level.LEVEL0, f);
		int newL = s.getLength();
		assertEquals(newL, formerL + 1);
		
		s = new Snake();
		f = new Food(Level.LEVEL3);
		formerL = s.getLength();
		s.addSnakeLength(Level.LEVEL3, f);
		newL = s.getLength();
		assertEquals(newL, formerL + 1);
	
	}

}
