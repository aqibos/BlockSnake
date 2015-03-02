package model;

import util.RandomNumberGenerator;

public class Fruit extends Block {
    public Fruit(int x, int y, int length) {
        super(x, y, length);
    }
    
    public void RandomizePos() {
        this.setX( RandomNumberGenerator.getRandIntBetween(0, (810 - 15)));
        this.setY( RandomNumberGenerator.getRandIntBetween(0, (450 - 15)));
    }
}
