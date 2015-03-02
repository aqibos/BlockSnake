package state;

import util.RandomNumberGenerator;
import main.GameMain;
import main.Resources;
import model.Fruit;
import model.Snake;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayState extends State {
    
    private Snake snake;
    private Fruit fruit;
    private int score;
    private Font scoreFont;

    @Override
    public void init() {
        snake = new Snake();
        snake.add();
        snake.add();
        fruit = new Fruit(0, 0, Snake.BLOCK_SIZE);
        fruit.RandomizePos();
        score = 0;
        scoreFont = new Font("Serif", Font.BOLD, 14);
    }

    @Override
    public void update() {
        fruit.update();
        snake.update();
        //snake.checkCollision();
        if (snake.isLoser()) {
            setCurrentState(new ScoreState(score));
        } else if (snake.getHead().getRect().intersects(fruit.getRect())){
            score++;
            snake.add();
            fruit.RandomizePos();
            fruit.update();
            while (snake.getHead().getRect().intersects(fruit.getRect())) {
                fruit.RandomizePos();
                fruit.update();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.white);
        //g.fillRect( 0, 0 , GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT );
        g.drawImage( Resources.playScreen, 0, 0, null );
        g.setColor(Resources.black);
        g.setFont(scoreFont);
        g.drawString("" + score, 50, 20);
        for (int i = 0; i < snake.getSize(); i++) {
            if (i==0) {
                g.drawImage( Resources.headBlock, snake.getHead().getX(), 
                snake.getHead().getY(), null);
            } else {
                g.drawImage( Resources.block, snake.get(i).getX(), 
                snake.get(i).getY(), null);
            }
        }
        
        g.drawImage( Resources.apple, fruit.getX(), fruit.getY(), null );
    }

    @Override
    public void onClick(MouseEvent e) {
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_UP && (!snake.isMovingDown() || !(snake.getSize() > 1))) {
            snake.accelUp();
        } else if ( e.getKeyCode() == KeyEvent.VK_DOWN && (!snake.isMovingUp() || !(snake.getSize() > 1))) {
            snake.accelDown();
        } else if ( e.getKeyCode() == KeyEvent.VK_RIGHT && (!snake.isMovingLeft() || !(snake.getSize() > 1))) {
            snake.accelRight();
        } else if ( e.getKeyCode() == KeyEvent.VK_LEFT && (!snake.isMovingRight() || !(snake.getSize() > 1))) {
            snake.accelLeft();
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
    }

}
