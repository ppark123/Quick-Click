package ui;

import main.ReflexGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//GUI based on SnakeWithBugs; link below:
public class ReflexGameApp extends JFrame {
    private static ReflexGame game;
    private final ReflexGameRenderer renderer;
    private int size;
    private int TIME_LIMIT = 200;

    public ReflexGameApp() {
        super("Reflex Game");
        game = new ReflexGame();
        size = game.BOARD_SIZE;
        this.renderer = new ReflexGameRenderer(game);
        this.addMouseListener(new MouseHandler());
        initializeGraphics();
        createTimer();
    }

    private void initializeGraphics() {
        this.setMinimumSize(new Dimension(size, size));
        this.setMaximumSize(new Dimension(size, size));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
@Override
    public void paint(Graphics graphics) {
     if (!game.isGameOver() && !game.gameWon()) {
            graphics.setColor(new Color(47, 66, 110));
            graphics.fillRect(0, 0, size, size);
            renderer.render(graphics);
        } else if (game.gameWon()) {
         graphics.drawString("You won!", this.getX()/2, this.getY()/2);
         graphics.setColor(new Color(0, 0, 0));
        } else {
            graphics.drawString("Game Over", this.getX()/2, this.getY()/2);
            graphics.setColor(new Color(0, 0, 0));

     }
    }

    private void createTimer() {
        Timer timer = new Timer(TIME_LIMIT, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.isGameOver()) {
                    timer.stop();
                    System.out.println("Game Over");
                } else if (game.gameWon()) {
                    showGameWon();
                    timer.stop();
                    System.out.println("You Won!");
                } else {
                    game.update();
                    repaint();
                }
            }
        });
        timer.start();
    }

    private void displayGameOver() {
        clearFrame();
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setForeground(Color.RED);
        this.add(gameOverLabel);

    }

    private void showGameWon() {
        //display timer

    }

    private void clearFrame() {
        this.getContentPane().removeAll();
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int block_X = game.getBlock().get_X();
            int block_Y = game.getBlock().get_Y();
            int blockSize = game.getBlock().getSize();
            if (e.getX() >= block_X && e.getX() <= (block_X+blockSize) && e.getY() >= block_Y &&
                    e.getY() <= (block_Y+blockSize)) {
                game.getBlock().changeClicked();
            }
        }
    }

    public static void main(String[] args) {new ReflexGameApp();}

}
