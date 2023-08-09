import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PlayerInputHandler implements KeyListener {

    private Board board;
    private Player currentPlayer;
    private int initialX;
    private int initialY;

    public PlayerInputHandler(Board board, Player currentPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.initialX = -1;
        this.initialY = -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_SPACE && initialX == -1 && initialY == -1) {
            initialX = currentPlayer.getX();
            initialY = currentPlayer.getY();
            board.setCell(initialX, initialY, currentPlayer.getColor());
        } else if (keyCode == KeyEvent.VK_UP) {
            handleMove(initialX, initialY - 1);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            handleMove(initialX, initialY + 1);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            handleMove(initialX - 1, initialY);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            handleMove(initialX + 1, initialY);
        }

        GUI.updateBoard(board); // Assuming GUI class has a static updateBoard() method
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void handleMove(int x, int y) {
        if (board.isValidCell(x, y)) {
            currentPlayer.setX(x);
            currentPlayer.setY(y);
            board.setCell(x, y, currentPlayer.getColor());
        }
    }

    // Implement other KeyListener methods (keyReleased, keyTyped) as needed
    // ...

}