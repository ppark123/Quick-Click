package main;

import java.awt.*;

//Block class that creates the block that the user has to click
public class Block {
    public static final int SIZE = 30;
    private int lifespan;
    private static Color BLOCK_COLOR;
    private boolean clicked;
    private int x_pos;
    private int y_pos;

    //EFFECTS: creates a new instance of a block with a position x, y, color and a lifespan
    public Block(int x, int y, int lifespan){
        this.lifespan = lifespan;
        this.BLOCK_COLOR = new Color(86, 178, 86);
        this.clicked = false;
        this.x_pos = x;
        this.y_pos = y;
    }

    //EFFECTS: decrements the lifespan of the block every second
    public void updateLifeSpan() {
        if (lifespan - 1 > 0) {
            lifespan -= 1;
        } else {
            lifespan = 0;
        }
    }

    //EFFECTS: updates the lifespan as well as the color of the block when the time is less than 5 seconds
    public void updateBlock() {
        updateLifeSpan();
        if (lifespan < 5) {
            changeColor();
        }
    }

    //EFFECTS: changes the color of the block from green to red
    public void changeColor() {
        BLOCK_COLOR = new Color(218, 79, 79);
    }

    //EFFECTS: returns the true if the block is still alive, false when the user fails to click it on time
    public boolean isAlive() {
        return (lifespan!=0);
    }

    public void setClicked() {
        this.clicked = true;
    }

    public boolean clicked() {
        return this.clicked;
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

    public int getSize() {
        return SIZE;
    }

    public void changeClicked() {
        clicked = true;
    }
}
