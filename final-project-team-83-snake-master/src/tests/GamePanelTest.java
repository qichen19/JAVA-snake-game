package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import snakeGame.Data;
import snakeGame.GamePanel;
import snakeGame.Level;
import snakeGame.Obstacle;
import snakeGame.Snake;

class GamePanelTest {

	@Test
	void testPlay() {
		GamePanel g = new GamePanel();
		g.play();
		assertEquals(g.getDirection(), "R");
		assertFalse(g.isStart());
		assertFalse(g.isFail());
		assertEquals(g.getS().getScore(), 0);
		assertEquals(g.getS().getMaxScore(), 0);
		assertEquals(g.getFood().getFoodImage(), Data.apple);
		assertEquals(g.getLevel(), Level.LEVEL0);
	}
	@Test
	void testEat() {
		GamePanel g = new GamePanel();
		g.getSnake().getSnakeX()[0] = g.getFood().getFoodX();
		g.getSnake().getSnakeY()[0] = g.getFood().getFoodY();
		g.setLevel(Level.LEVEL0);
		int formerL = g.getSnake().getLength();
		int formerS = g.getS().getScore();
		g.eat();
		assertEquals(g.getSnake().getLength(), formerL+1);
		assertEquals(g.getS().getScore(), formerS + 1);
	}
	@Test
	// tests if the snake eats itself, will the game ends?
	void testEndOfGameRule1() {
		GamePanel g = new GamePanel();
		g.getSnake().setLength(100);
		for(int i = 1; i < g.getSnake().getLength(); i++) {
			g.getSnake().getSnakeX()[0] = g.getSnake().getSnakeX()[i];
			g.getSnake().getSnakeY()[0] = g.getSnake().getSnakeY()[i];
			g.endOfGame();
			assertTrue(g.isFail());	
		}
	}
	@Test
	// tests if the snake hits the boundary, will the game ends?
	void testEndOfGameRule2() {
		GamePanel g = new GamePanel();
		String direction = "L";
		g.endOfGame();
		if (g.getSnake().snakeHitBoundary(direction)) {
			assertTrue(g.isFail());
		}
		direction = "R";
		if (g.getSnake().snakeHitBoundary(direction)) {
			assertTrue(g.isFail());
		}
		direction = "U";
		if (g.getSnake().snakeHitBoundary(direction)) {
			assertTrue(g.isFail());
		}
		direction = "D";
		if (g.getSnake().snakeHitBoundary(direction)) {
			assertTrue(g.isFail());
		}
	}	

	@Test
	// tests if the snake hits the obstacle, will the game ends?
	void testEndOfGameRule3() { 
		GamePanel g = new GamePanel();
		g.setLevel(Level.LEVEL1);
		g.setObstacle(new Obstacle(Level.LEVEL1));
		for(int i = 0; i < g.getObstacle().getLength(); i++) {
			g.getSnake().getSnakeX()[0] = g.getObstacle().getObstacleX();
			g.getSnake().getSnakeY()[0] = g.getObstacle().getObstacleY()[i];
			g.endOfGame();
			assertTrue(g.isFail());				
		}	

		g.setLevel(Level.LEVEL2);
		g.setObstacle(new Obstacle(Level.LEVEL2));
		for(int i = 0; i < g.getObstacle().getLength(); i++) {
			g.getSnake().getSnakeX()[0] = g.getObstacle().getOX2();
			g.getSnake().getSnakeY()[0] = g.getObstacle().getOY2()[i];
			g.endOfGame();
			assertTrue(g.isFail());				
		}	

		g.setLevel(Level.LEVEL3);
		g.setObstacle(new Obstacle(Level.LEVEL3));
		g.getSnake().getSnakeX()[0] = g.getObstacle().getoX3();
		g.getSnake().getSnakeY()[0] = g.getObstacle().getoY3();
		g.endOfGame();
		assertTrue(g.isFail());				

	}
	@Test
	void testUpdateLevel() {
		GamePanel g = new GamePanel();
		g.getS().setScore(1);
		g.updateLevel();
		assertEquals(g.getLevel(), Level.LEVEL0);

		g.getS().setScore(5);
		g.updateLevel();
		assertEquals(g.getLevel(), Level.LEVEL1);
		assertEquals(g.getObstacle().getObstacleImage(), Data.obstacle);

		g.getS().setScore(10);
		g.updateLevel();
		assertEquals(g.getLevel(), Level.LEVEL2);
		assertEquals(g.getObstacle().getObstacleImage(), Data.bomb);

		g.getS().setScore(15);
		g.updateLevel();
		assertEquals(g.getLevel(), Level.LEVEL3);
		assertEquals(g.getObstacle().getObstacleImage(), Data.meteor2);	
	}


}
