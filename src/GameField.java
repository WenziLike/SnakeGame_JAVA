import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 400;
    private Image dotted;
    private Image quince;
    private int quinceX;
    private int quinceY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;


    public GameField() {
        setBackground(Color.BLACK);
        loadImages();
        initGame();
    }

    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createEquince();
    }

    public void createEquince() {
        quinceX = new Random().nextInt(20) * DOT_SIZE;
        quinceY = new Random().nextInt(20) * DOT_SIZE;

    }

    public void loadImages() {
        ImageIcon iiq = new ImageIcon("quince.png");
        quince = iiq.getImage();

        ImageIcon iid = new ImageIcon("dotted.png");
        dotted = iiq.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(quince, quinceX, quinceY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dotted, x[i], y[i], this);
            }
        }
    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= DOT_SIZE;
        }
        if (right) {
            x[0] += DOT_SIZE;
        }
        if (up) {
            y[0] -= DOT_SIZE;
        }
        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    public void chekQuince() {
        if (x[0] == quinceX && y[0] == quinceY) {
            dots++;
            createEquince();
        }
    }

    public void checkCollisions() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }
        if (x[0] > SIZE) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        if (y[0] > SIZE) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            chekQuince();
            checkCollisions();
            move();
        }
        repaint();
    }
}
