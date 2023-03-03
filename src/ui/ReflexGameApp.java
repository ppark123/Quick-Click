package ui;

import main.ReflexGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

//GUI based on SnakeWithBugs; link below:
public class ReflexGameApp extends JFrame {
    private static ReflexGame game;
    private final ReflexGameRenderer renderer;
    private int size;
    private int TIME_LIMIT = 200;
    private Scanner scanner;
    private long timeStart;
    int FPS = 60;


    public ReflexGameApp() {
        super("Reflex Game");
        game = new ReflexGame();
        size = game.BOARD_SIZE;
        this.renderer = new ReflexGameRenderer(game);
        timeStart = System.currentTimeMillis();
        scanner = new Scanner(System.in);
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

    private String returnTime(){
        long stopTime = System.currentTimeMillis();
        long totalTime = stopTime - timeStart;
        long sec = totalTime/1000;
        long msec = totalTime - sec;
        return "Total time: " + sec + "." + msec + "s";
    }
    
@Override
    public void paint(Graphics graphics) {
     if (!game.isGameOver() && !game.gameWon()) {
            graphics.setColor(new Color(47, 66, 110));
            graphics.fillRect(0, 0, size, size);
            renderer.render(graphics);
        } else if (game.gameWon()) {
         graphics.drawString("You won!", (size/2)-30, size/2);
         graphics.drawString(returnTime(),(size/2)-70, size/2+30);
         graphics.setColor(new Color(0, 0, 0));
        } else {
            graphics.drawString("Game Over", size/2-30, size/2);
            graphics.setColor(new Color(0, 0, 0));

     }
    }

    private void createTimer() {
        double interval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (!game.isGameOver() && !game.gameWon()) {
            currentTime = System.nanoTime();
            delta+=(currentTime - lastTime) / interval;
            lastTime = currentTime;
            if (delta>=1){
                game.update();
                repaint();
                delta--;
            }
        }

//        Timer timer = new Timer(TIME_LIMIT, null);
//
//        timer.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (game.isGameOver()) {
//                    timer.stop();
//                    System.out.println("Game Over");
//                } else if (game.gameWon()) {
//                    timer.stop();
//                    System.out.println("You Won!");
//                } else {
//                    game.update();
//                    repaint();
//                }
//            }
//        });
//        timer.start();
    }

    private void displayGameOver() {
        clearFrame();
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setForeground(Color.RED);
        this.add(gameOverLabel);

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
