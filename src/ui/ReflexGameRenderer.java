package ui;

import main.ReflexGame;

import java.awt.*;

public class ReflexGameRenderer {
    private ReflexGame game;

    public ReflexGameRenderer(ReflexGame g){
        this.game = g;
    }
    public void render(Graphics g) {
        renderBlock(g);
    }

    private void renderBlock(Graphics g) {
        g.drawRect(game.getBlock().get_X(), game.getBlock().get_Y(), game.getBlock().getSize(), game.getBlock().getSize());
    }

}
