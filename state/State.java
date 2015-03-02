package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.GameMain;

public abstract class State {

	//Initializes new state
	public abstract void init();
	
	//Update current state - called by game loop
	public abstract void update();
	
	//Loads images for current state - called by game loop
	public abstract void render( Graphics g );
	
	//User input - called when user clicks
	public abstract void onClick( MouseEvent e );
	
	//User input - called when user presses key
	public abstract void onKeyPress( KeyEvent e );
	
	//User input - called when user releases key
	public abstract void onKeyRelease( KeyEvent e );
	
	public void setCurrentState( State newState ) {
		
		GameMain.sGame.setCurrentState( newState );
		
	}
	
}
