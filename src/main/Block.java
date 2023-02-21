package main;

import java.awt.*;

public class Block {
    private static final int SIZE = 10;
    private int lifespan;
    private static Color BLOCK_COLOR;
    private boolean alive;
    private int x_pos;
    private int y_pos;

    public Block(int x, int y, int lifespan){
        this.lifespan = lifespan;
        this.BLOCK_COLOR = new Color(86, 178, 86);
        this.alive = true;
        this.x_pos = x;
        this.y_pos = y;
    }

    public void updateLifeSpan() {
        if (lifespan - 1 > 0) {
            lifespan--;
        } else {
            lifespan = 0;
            this.alive = false;
        }
    }

    public void update() {
        if (lifespan < 5) {
            changeColor();
        }
        updateLifeSpan();
    }

    public void changeColor() {
        BLOCK_COLOR = new Color(218, 79, 79);
    }


    public boolean isAlive() {
        return alive;
    }

    public int get_X() {
        return x_pos;
    }

    public int get_Y() {
        return y_pos;
    }

    public Color get_Color() {
        return BLOCK_COLOR;
    }

    public int getLife() {
        return lifespan;
    }
}
