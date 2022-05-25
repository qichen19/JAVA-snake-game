package snakeGame;
/**
 * @author Yunyang Li, Qi Chen, Xiaoge Fan
 * This StartGames class contains the main method. 
 */
import javax.swing.*;

public class StartGames {
	/**
	* This is the main method of this game
	* initiates a game frame and adds game panel to the frame
	*/
	public static void main(String[] args) {
		// makes a frame 
		JFrame frame = new JFrame("Snake game");
		// sets window size
		frame.setBounds(10, 10, 900, 720);
		frame.setResizable(false);
		//sets closing game event
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		//adds game panel to frame
		frame.add(new GamePanel());				
		//lets the window be visible
		frame.setVisible(true);
	}
}
