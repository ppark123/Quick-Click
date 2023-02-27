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
    private static final String instText = "Press start to begin the game";
    private static final String startText = "Start";
    private static ReflexGame game;
    private ReflexGameRenderer renderer;
    private int size;
    private int TIME_LIMIT = 1000;

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
        this.setSize(new Dimension(size, size));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
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
        super.paint(graphics);
        graphics.fillRect(0,0, size, size);
        renderer.render(graphics);
    }

    private void createTimer() {
        Timer timer = new Timer(TIME_LIMIT, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.isGameOver()) {
                    timer.stop();
                } else {
                    game.update();
                    repaint();
                }
            }
        }
        );
        timer.start();
    }

    private void setUpFrame() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void clearFrame() {
        this.getContentPane().removeAll();
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getX() >= (game.getBlock().get_X()-game.getBlock().getSize()) &&
                    e.getX() <= (game.getBlock().get_X()+game.getBlock().getSize()) &&
                    e.getY() >= (game.getBlock().get_Y()-game.getBlock().getSize()) &&
                    e.getY() <= (game.getBlock().get_Y()+game.getBlock().getSize())) {
                game.getBlock().changeClicked();
            }
        }
    }

    public static void main(String[] args) {new ReflexGameApp();}

}
