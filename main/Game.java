package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import state.State;
import state.LoadState;
import util.InputHandler;

@SuppressWarnings("serial")							//Tells Eclipse to not give warnings regarding what is called a "Serial Version ID"

public class Game extends JPanel implements Runnable {
	
	//Instance var's
	private int gameWidth, gameHeight;
	
	private Image gameImage;
	
	private Thread gameThread;
	
	private volatile boolean running;
	
	private volatile State currentState;
	
        private InputHandler inputHandler;
        
	
	//Constructor
	public Game( int gameWidth, int gameHeight ) {
		
		this.gameWidth = gameWidth;
		
		this.gameHeight = gameHeight;
		
		setPreferredSize( new Dimension( gameWidth, gameHeight ) );
		
		setBackground( Color.BLACK );
		
		setFocusable( true );			//Allow for keyboard input
		
		requestFocus();
		
	}
	
	
	//Sets new state to current state
	public void setCurrentState( State newState ) {
		
		System.gc(); 
		
		newState.init();
                
                currentState = newState;
                
                inputHandler.setCurrentState( currentState );
            
		
	}
	
	//Overrides addNotify of JFrame
	public void addNotify() {
		
		super.addNotify();
                
                initInput();
		
		setCurrentState( new LoadState() );
		
		initGame();
		
	}
        
        
        private void initInput() {
            
            inputHandler = new InputHandler();
            
            addKeyListener( inputHandler );
            
            addMouseListener( inputHandler );
            
        }
	
	
	private void initGame() {
		
		running = true;
		
		gameThread = new Thread( this, "Game Thread" );
                
		gameThread.start();     //Calls run()
                
	}


	@Override
	public void run() {
		
		while ( running ) {
			
			currentState.update();
			
			prepareGameImage();
			
			currentState.render( gameImage.getGraphics() );
			
			repaint();	//Calls paintComponent
			
			try {
				
				Thread.sleep( 30 );
				
			} catch ( InterruptedException e ) {
				
				e.printStackTrace();
				
			}
			
		}
		
		System.exit( 0 );
		
	}
	
	
	private void prepareGameImage() {
		
		if ( gameImage == null ) {
			
			gameImage = createImage( gameWidth, gameHeight );
			
		} 
		
		Graphics g = gameImage.getGraphics();
		
		g.clearRect( 0, 0, gameWidth, gameHeight );
		
	}
	
	
	public void exit() {
		
		running = false;
		
	}
	
	public void paintComponent( Graphics g ) {
		
		super.paintComponent( g );
		
		if ( gameImage == null ) {
			
			return;
			
		}
		
		g.drawImage( gameImage, 0, 0, null );
		
	}

}
