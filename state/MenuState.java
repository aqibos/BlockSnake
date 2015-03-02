package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Resources;

public class MenuState extends State {

	@Override
	public void init() {
		
            //System.out.println( "Entered MenuState." );
		
	}

	@Override
	public void update() {
		
		
		
	}

	@Override
	public void render(Graphics g) {
		
            g.drawImage( Resources.welcome, 0, 0, null );
		
	}

	@Override
	public void onClick(MouseEvent e) {
	
            setCurrentState(new InstructionState());
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		
            System.out.println("KeyPress!");
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {

            System.out.println("KeyRelease!");
		
	}

}
