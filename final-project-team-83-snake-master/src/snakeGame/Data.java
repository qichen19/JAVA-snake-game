package snakeGame;
/**
 * @author Yunyang Li, Qi Chen, Xiaoge Fan
 * This Data class contains image icons and sounds which will be used for the game
 */

import java.applet.Applet;

import java.applet.AudioClip;
import java.net.URL;

import javax.swing.*;

public class Data {	
	//gets header picture
	public static URL backURL = Data.class.getResource("/statics/back.png");
	public static ImageIcon back = new ImageIcon(backURL);
	
	public static URL back2URL = Data.class.getResource("/statics/back2.png");
	public static ImageIcon back2 = new ImageIcon(back2URL);
	
	public static URL back3URL = Data.class.getResource("/statics/back3.png");
	public static ImageIcon back3 = new ImageIcon(back3URL);
	
	//gets snake's head pictures. Head to left, right, up and down
	public static URL upURL = Data.class.getResource("/statics/up.png");
	public static ImageIcon up = new ImageIcon(upURL);
	
	public static URL downURL = Data.class.getResource("/statics/down.png");
	public static ImageIcon down = new ImageIcon(downURL);
	
	public static URL leftURL = Data.class.getResource("/statics/left.png");
	public static ImageIcon left = new ImageIcon(leftURL);
	
	public static URL rightURL = Data.class.getResource("/statics/right.png");
	public static ImageIcon right = new ImageIcon(rightURL);
	
	public static URL up3URL = Data.class.getResource("/statics/up3.png");
	public static ImageIcon up3 = new ImageIcon(up3URL);
	
	public static URL down3URL = Data.class.getResource("/statics/down3.png");
	public static ImageIcon down3 = new ImageIcon(down3URL);
	
	public static URL left3URL = Data.class.getResource("/statics/left3.png");
	public static ImageIcon left3 = new ImageIcon(left3URL);
	
	public static URL right3URL = Data.class.getResource("/statics/right3.png");
	public static ImageIcon right3 = new ImageIcon(right3URL);
	
	//gets snake's body picture	
	public static URL bodyURL = Data.class.getResource("/statics/body.png");
	public static ImageIcon body = new ImageIcon(bodyURL);
	
	public static URL body3URL = Data.class.getResource("/statics/body3.png");
	public static ImageIcon body3 = new ImageIcon(body3URL);
	
	//gets obstacle picture
	public static URL obstacleURL = Data.class.getResource("/statics/obstacle.png");
	public static ImageIcon obstacle = new ImageIcon(obstacleURL);
	
	public static URL seaUrchinURL = Data.class.getResource("/statics/seaUrchin.png");
	public static ImageIcon seaUrchin = new ImageIcon(seaUrchinURL);
	
	public static URL meteor2URL = Data.class.getResource("/statics/meteor2.png");
	public static ImageIcon meteor2 = new ImageIcon(meteor2URL);
	
	//gets food pictures
	public static URL appleURL = Data.class.getResource("/statics/apple.png");
	public static ImageIcon apple = new ImageIcon(appleURL);
	
	public static URL pearURL = Data.class.getResource("/statics/pear.png");
	public static ImageIcon pear = new ImageIcon(pearURL);
	
	public static URL peachURL = Data.class.getResource("/statics/peach.png");
	public static ImageIcon peach = new ImageIcon(peachURL);
	
	public static URL starURL = Data.class.getResource("/statics/star.png");
	public static ImageIcon star = new ImageIcon(starURL);
	
	public static URL shrimpURL = Data.class.getResource("/statics/shrimp.png");
	public static ImageIcon shrimp = new ImageIcon(shrimpURL);
	
	public static URL bombURL = Data.class.getResource("/statics/bomb.png");
	public static ImageIcon bomb = new ImageIcon(bombURL);
	
	public static URL crabURL = Data.class.getResource("/statics/crab.png");
	public static ImageIcon crab = new ImageIcon(crabURL);
		
	//gets game ending sound
	public static URL endURL = Data.class.getResource("/statics/ending.wav");
	public static AudioClip endClip = Applet.newAudioClip(endURL);
	
	//gets snake eat sound
	public static URL eatURL = Data.class.getResource("/statics/eat.wav");
	public static AudioClip eatClip = Applet.newAudioClip(eatURL);
	
	//gets explosion sound
	public static URL explodeURL = Data.class.getResource("/statics/explosion.wav");
	public static AudioClip explodeClip = Applet.newAudioClip(explodeURL);
	
	//gets snake move sound
	public static URL moveLeftURL = Data.class.getResource("/statics/DO_piano.wav");
	public static AudioClip moveLeftClip = Applet.newAudioClip(moveLeftURL);
	public static URL moveRightURL = Data.class.getResource("/statics/RE_piano.wav");
	public static AudioClip moveRightClip = Applet.newAudioClip(moveRightURL);
	public static URL moveUpURL = Data.class.getResource("/statics/MI_piano.wav");
	public static AudioClip moveUpClip = Applet.newAudioClip(moveUpURL);
	public static URL moveDownURL = Data.class.getResource("/statics/SO_piano.wav");
	public static AudioClip moveDownClip = Applet.newAudioClip(moveDownURL);
	
}
