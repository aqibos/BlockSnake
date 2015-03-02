package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

public class Resources {
	
	public static BufferedImage welcome, iconimage, instruction, block, 
                headBlock, apple, controlScreen, playScreen, scoreScreen;
        
        public static Color black, white;
	
	
	//Loads resources
	public static void load() {
		
		welcome = loadImage( "welcome.jpg" );
		
		iconimage = loadImage( "iconimage.png" );
                
                instruction = loadImage("Instructions.png");
                
                block = loadImage("block.png");
                
                headBlock = loadImage("headblock.png");
		
                apple = loadImage("Apple15x15.png");
                
                black = new Color(0, 0, 0);
                
                white = new Color(255, 255, 255);
                
                controlScreen = loadImage("controlScreen.png");
                playScreen = loadImage("playScreen.png");
                scoreScreen = loadImage("scoreScreen.png");
	}
	
	
	//Loads an audio clip given the name
	private static AudioClip loadSound( String filename ) {
		
		URL fileURL = Resources.class.getResource( "/resources/" + filename );
		
		return Applet.newAudioClip( fileURL );
		
	}
	
	
	//Loads an image given the name
	private static BufferedImage loadImage( String filename ) {
		
		BufferedImage img = null;
		
		try {
			
			img = ImageIO.read( Resources.class.getResourceAsStream( "/resources/" + filename ) );
			
		} catch ( Exception e ) {
			
			System.out.println( "Error while reading: "+ filename );
			
			e.printStackTrace();
			
		}
		
		return img;
		
	}
	
	

}
