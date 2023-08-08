import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private Board board;
    private Player player;

    public GUI() {
        board = new Board(800,600,Color.WHITE);
        player = new Player(2, 3, Color.RED);

        setTitle("Paint IoT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(board.getWidth(), board.getHeight());

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        setVisible(true);
    }

    public void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            player.moveUp();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            player.moveDown();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            player.moveLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            player.moveRight();
        }

        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        board.draw(g);
        player.draw(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}