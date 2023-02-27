package ui;

import main.ReflexGame;

import java.awt.*;

//EFFECTS: renders the blocks of the reflexGame onto the screen
public class ReflexGameRenderer {
    private ReflexGame game;

    //sets the member variable game equal to the pre-existing game
    public ReflexGameRenderer(ReflexGame game){
        this.game = game;
    }

    //EFFECTS: renders the block onto the screen
    public void render(Graphics g) {
        renderBlock(g);
    }

    //EFFECTS: renders the Block as a rectangle onto the screen with color and size
    private void renderBlock(Graphics g) {
        if (!game.gameWon()) {
            g.setColor(game.getBlock().get_Color());
            final int SIZE = game.getBlock().getSize();
            g.fillRect(game.getBlock().get_X(), game.getBlock().get_Y(), SIZE, SIZE);
        }
    }

}
