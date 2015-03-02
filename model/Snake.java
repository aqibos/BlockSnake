package model;

import main.GameMain;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Block> snake;
    private Block head, tail;
    private int size;
    private final static int MOVE_SPEED = 15;
    public final static int BLOCK_SIZE = 15;
    private boolean isLoser;
    private boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight;
    
    public Snake() {
        snake = new LinkedList<>();
        snake.add(new Block(400, 225, BLOCK_SIZE));
        head = snake.getFirst();
        tail = snake.getLast();
        isMovingUp = false;
        isMovingDown = false;
        isMovingLeft = false;
        isMovingRight = false;
        isLoser = false;
        size = 1;
    }
    
    public void add() {
        Block temp;
        if (isMovingUp) {
           temp = new Block(tail.getX(), 
            tail.getY() + BLOCK_SIZE, BLOCK_SIZE); 
        } else if (isMovingDown) {
            temp = new Block(tail.getX(), 
            tail.getY() - BLOCK_SIZE, BLOCK_SIZE);
        } else if (isMovingRight) {
            temp = new Block(tail.getX() - BLOCK_SIZE, 
            tail.getY(), BLOCK_SIZE);
        } else {
            temp = new Block(tail.getX() + BLOCK_SIZE, 
            tail.getY(), BLOCK_SIZE);
        }
        
        snake.add(temp);
        tail = snake.getLast();
        size++;
    }
    
    public void update() {
        if (isMovingUp) {
            accelUp();
        } else if (isMovingDown) {
            accelDown();
        } else if (isMovingLeft) {
            accelLeft();
        } else if (isMovingRight) {
            accelRight();
        }
        
        checkCollision();
        
        for(Block b: snake) {
            b.update();
        }
    }
    
    public void checkCollision() {
        if (head.getX() < 0 ||
                head.getY() < 0 ||
                head.getX() > (GameMain.GAME_WIDTH - BLOCK_SIZE) ||
                head.getY() > (GameMain.GAME_HEIGHT - BLOCK_SIZE)) {
            isLoser = true;
        } 
        
        for (Block b : snake) {
            if (b != head && head.getRect().intersects(b.getRect())) {
                isLoser = true;
            }
        }
                        
    }
    
    public void accelUp() {
        setDirection(true, false, false, false);
        snake.addFirst( new Block(head.getX(), 
                head.getY() - MOVE_SPEED, BLOCK_SIZE));
        snake.removeLast();
        updateHeadTail();
    }
    
    public void accelDown() {
        setDirection(false, true, false, false);
        snake.addFirst( new Block(head.getX(), 
                head.getY() + MOVE_SPEED, BLOCK_SIZE));
        snake.removeLast();
        updateHeadTail();
    }
    
    public void accelRight() {
        setDirection(false, false, true, false);
        snake.addFirst( new Block(head.getX() + MOVE_SPEED, 
                head.getY(), BLOCK_SIZE));
        snake.removeLast();
        updateHeadTail();
    }
    
    public void accelLeft() {
        setDirection(false, false, false, true);
        snake.addFirst( new Block(head.getX() - MOVE_SPEED, 
                head.getY(), BLOCK_SIZE));
        snake.removeLast();
        updateHeadTail();
    }
    
    private void updateHeadTail() {
        head = snake.getFirst();
        tail = snake.getLast();
    }
    
    private void setDirection(boolean up, boolean down, 
            boolean right, boolean left) {
        isMovingUp = up;
        isMovingDown = down;
        isMovingRight = right;
        isMovingLeft = left;
    }
    
    public Block getHead() {
        return head;
    }
    
    public Block get(int index) {
        return snake.get(index);
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isLoser() {
        return isLoser;
    }
    
    public boolean isMovingUp() {
        return isMovingUp;
    }
    
    public boolean isMovingDown() {
        return isMovingDown;
    }
    
    public boolean isMovingRight() {
        return isMovingRight;
    }
    
    public boolean isMovingLeft() {
        return isMovingLeft;
    }
}
