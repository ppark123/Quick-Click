package ui;

import main.ReflexGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//GUI based on SnakeWithBugs; link below:
public class ReflexGameApp extends JFrame {
    private static final String instText = "Press start to begin the game";
    private static final String startText = "Start";
    private static ReflexGame game;
    private ReflexGameRenderer renderer;
    private static final int size = game.BOARD_SIZE;
    private int TIME_LIMIT = 500;

    public ReflexGameApp() {
        super("Reflex Game");
        initializeGraphics();
    }

    private void initializeGraphics() {
        JButton button = startButton();
        this.add(button, BorderLayout.CENTER);
        this.setMinimumSize(new Dimension(size, size));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(size, size));
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }

    private JButton startButton() {
        JButton button = new JButton("Start");
        button.setBounds(size/2, size/2, size/2, 100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGamePanel();
            }
        });
        return button;
    }

    private void startGamePanel() {
        clearFrame();
        JPanel gamePanel = new JPanel();
        startGame();
    }

    private void startGame() {
        game = new ReflexGame();
        renderer = new ReflexGameRenderer(game);
        createTimer();

    }

    @Override
    public void paint(Graphics g) {
        renderer.render(g);
    }

    private void createTimer() {
        Timer timer = new Timer(TIME_LIMIT, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!game.isGameOver()) {
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

    public static void main(String[] args) {new ReflexGameApp();}
}
