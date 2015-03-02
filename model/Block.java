package model;

import java.awt.Rectangle;

/**
 * Represents a segment on the Snake.
 * @author Aqib S.
 */
public class Block {
    private int x, y, length;
    private Rectangle rect;
    
    /**
     * Instantiates a block.
     * @param x - x coordinate
     * @param y - y coordinate
     * @param length - length of block
     */
    public Block(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
        rect = new Rectangle(x, y, length, length);
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getLen() { return length; }
    public Rectangle getRect() { return rect; }
    
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    
    public void update() {
        updateRect();
    }
    
    private void updateRect() {
        rect.setBounds(x, y, length, length);
    }
 }