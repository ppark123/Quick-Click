package ui;

import main.ReflexGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//GUI based on SnakeWithBugs; link below:
public class ReflexGameApp extends JFrame implements MouseListener {
    private static final String instText = "Press start to begin the game";
    private static final String startText = "Start";
    private static ReflexGame game;
    private ReflexGameRenderer renderer;
    private static final int size = game.BOARD_SIZE;
    private int TIME_LIMIT = 100;

    public ReflexGameApp() {
        super("Reflex Game");
        game = new ReflexGame();
        this.renderer = new ReflexGameRenderer(game);
        addMouseListener(this);
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
        graphics.fillRect(0,0, size, size);
        renderer.render(graphics);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= (game.getBlock().get_X()-game.getBlock().getSize()) &&
                e.getX() <= (game.getBlock().get_X()+game.getBlock().getSize()) &&
                e.getY() >= (game.getBlock().get_Y()-game.getBlock().getSize()) &&
                e.getY() <= (game.getBlock().get_Y()+game.getBlock().getSize())) {
            game.getBlock().changeClicked();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
