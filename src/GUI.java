import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener {
    private Board board;
    private Player player;

    public GUI() {
        board = new Board(800, 600);
        player = new Player(400, 300, Color.BLUE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(board.getWidth(), board.getHeight());
        setTitle("Paint.io Game");
        setResizable(false);
        setLocationRelativeTo(null);

        addKeyListener(this);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };
        getContentPane().add(panel);

        gameLoop();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                player.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                player.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                player.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                player.moveRight();
                break;
            default:
                // Handle other key presses if necessary
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key release event if necessary
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed event if necessary
    }

    private void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, board.getWidth(), board.getHeight());

        board.draw(g);
        player.draw(g);
    }

    private void gameLoop() {
        while (true) {
            player.update();

            repaint();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}