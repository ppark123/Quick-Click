package main;

import java.util.Random;

//A reflex game that includes a clicking on a set of ten blocks in the shortest time possible
public class ReflexGame {
    public static final int BOARD_SIZE = 500;
    private final Random randomNumber;
    private Block block;
    private int blockNumber;
    private int lifespan;

    //EFFECTS: creates a new instance of a reflexgame
    public ReflexGame() {
        randomNumber = new Random();
        lifespan = 120;
        blockNumber = 10;
        block = newBlock();
    }

    //EFFECTS: updates the board conditions every second
    public void update() {
        block.updateBlock();
        if (block.clicked()) {
            updateBlockNumber();
            updateLifeSpan();
            block = newBlock();
        }
    }

    //EFFECTS: decrements the block number once the previous block has been clicked on time
    public void updateBlockNumber() {
        this.blockNumber--;
    }

    //EFFECTS: updates the lifespan of the to be made block (decreases lifespan to make it harder)
    public void updateLifeSpan() {
        if (this.lifespan - 1 > 0) this.lifespan-=5;
    }

    //EFFECTS: returns true if the block is still alive
    public boolean isGameOver(){
        return !block.isAlive();
    }

    //EFFECTS: returns true if the block is still alive
    public boolean gameWon(){
        return (blockNumber==0);
    }

    //EFFECTS: creates a new block at a random x and y position on the board
    private Block newBlock() {
        int lowerBound = Block.SIZE;
        int x = randomNumber.nextInt(BOARD_SIZE-lowerBound);
        if (x<lowerBound) x+=lowerBound;
        int y = randomNumber.nextInt(BOARD_SIZE - lowerBound);
        if (y<lowerBound) y+=lowerBound;
        System.out.println("xcoord: " + x);
        System.out.println("Ycoord: " + y);
        return new Block(x, y, lifespan);
    }

    public int getBlockNumber() {
        return this.blockNumber;
    }

    public int getLifespan() {
        return this.lifespan;
    }

    public Block getBlock() {
        return this.block;
    }
}
