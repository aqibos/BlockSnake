package state;

import main.Resources;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InstructionState extends State {

    @Override
    public void init() {
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage( Resources.controlScreen, 0, 0, null );
    }

    @Override
    public void onClick(MouseEvent e) {
        setCurrentState(new PlayState());
    }

    @Override
    public void onKeyPress(KeyEvent e) {
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
    }
    
}
