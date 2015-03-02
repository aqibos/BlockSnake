package main;

import javax.swing.JFrame;

public class GameMain {
	
	//"Class" Var's
	private static final String GAME_TITLE = "BlockSnake";
	
	public static final int GAME_WIDTH = 810;
	
	public static final int GAME_HEIGHT = 450;
	
	public static Game sGame;
	
	
	//Begin Main
	public static void main( String [] args ) {
		
		JFrame frame = new JFrame( GAME_TITLE );
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		frame.setResizable( false );
		
		sGame = new Game( GAME_WIDTH, GAME_HEIGHT );
		
		frame.add( sGame );                             //Same as 'frame.add( BorderLayout.CENTER, sGame );
		
		frame.pack();						//Tells JFrame to resize to preferred size
		
		frame.setVisible( true );
                
                frame.setIconImage( Resources.iconimage );
		
	}

}
