package state;

import main.Resources;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ScoreState extends State {
    private int score;
    private Font scoreFont;
    
    public ScoreState(int score) {
        this.score = score;
    }
    
    @Override
    public void init() {
        scoreFont = new Font("Serif", Font.BOLD, 100);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage( Resources.scoreScreen, 0, 0, null );
        g.setColor(Resources.black);
        g.setFont(scoreFont);
        g.drawString("" + score, 350, 250);
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
