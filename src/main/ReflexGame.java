package main;

import java.util.Random;

public class ReflexGame {
    public static final int BOARD_SIZE = 30;
    private Random randomNumber;
    private Block block;
    private int lifespan;

    public ReflexGame() {
        randomNumber = new Random();
        lifespan = 20;
        block = newBlock();
    }

    public void update() {
        block.update();
        updateLifeSpan();
        newBlock();
    }

    public void updateLifeSpan() {
        if (this.lifespan - 5 > 0) {
            this.lifespan -= 2;
        }
        this.lifespan = 0;
    }
    public boolean isGameOver(){
        return block.isAlive();
    }

    private Block newBlock() {
        int x = randomNumber.nextInt(BOARD_SIZE);
        int y = randomNumber.nextInt(BOARD_SIZE);
        return new Block(x, y, lifespan);
    }


}
