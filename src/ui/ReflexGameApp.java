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

//    private JButton startButton() {
//        JButton button = new JButton("Start");
//        button.setBounds(size/2, size/2, size/2, 100);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                startGamePanel();
//            }
//        });
//        return button;
//    }

@Override
    public void paint(Graphics graphics) {
        graphics.setColor(new Color(40, 40, 40));
        graphics.fillRect(0,0, size, size);
        renderer.render(graphics);
    }

    private void createTimer() {
        Timer timer = new Timer(TIME_LIMIT, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.isGameOver()) {
                    showGameOver();
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

    private void showGameWon() {
        //display timer

    }

    private void showGameOver() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout(1,1));
        buttonPanel.setPreferredSize(new Dimension(size, size));
        JButton gameOverButton = gameOverButton();
        buttonPanel.add(gameOverButton, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        buttonPanel.setVisible(true);
    }

    private JButton gameOverButton() {
        JButton gameOverButton = new JButton("Game Over");
        gameOverButton.setActionCommand("game_over");
        gameOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Do you want to restart?",
                        "Game Over",
                        JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                } else {
                }
            }
        });
        return gameOverButton;
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
            if (e.getX() >= (block_X-blockSize) && e.getX() <= (block_X+blockSize) && e.getY() >= (block_Y-blockSize) &&
                    e.getY() <= (block_Y+blockSize)) {
                game.getBlock().changeClicked();
            }
        }
    }

    public static void main(String[] args) {new ReflexGameApp();}

}
