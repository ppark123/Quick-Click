package main;

import java.awt.*;

//Block class that creates the block that the user has to click
public class Block {
    private static final int SIZE = 10;
    private int lifespan;
    private static Color BLOCK_COLOR;
    private boolean alive;
    private int x_pos;
    private int y_pos;

    //EFFECTS: creates a new instance of a block with a position x, y, color and a lifespan
    public Block(int x, int y, int lifespan){
        this.lifespan = lifespan;
        this.BLOCK_COLOR = new Color(86, 178, 86);
        this.alive = true;
        this.x_pos = x;
        this.y_pos = y;
    }

    //EFFECTS: decrements the lifespan of the block every second
    public void updateLifeSpan() {
        if (lifespan - 1 > 0) {
            lifespan--;
        } else {
            lifespan = 0;
            this.alive = false;
        }
    }

    //EFFECTS: updates the lifespan as well as the color of the block when the time is less than 5 seconds
    public void update() {
        if (lifespan < 5) {
            changeColor();
        }
        updateLifeSpan();
    }

    //EFFECTS: changes the color of the block from green to red
    public void changeColor() {
        BLOCK_COLOR = new Color(218, 79, 79);
    }

    //EFFECTS: returns the true if the block is still alive, false when the user fails to click it on time
    public boolean isAlive() {
        return alive;
    }

    //EFFECTS: returns the x position of the block
    public int get_X() {
        return x_pos;
    }

    //EFFECTS: returns the y position of the block
    public int get_Y() {
        return y_pos;
    }

    //EFFECTS: returns the color of the block
    public Color get_Color() {
        return BLOCK_COLOR;
    }

    //EFFECTS: returns the time limit of the block
    public int getLife() {
        return lifespan;
    }
}
