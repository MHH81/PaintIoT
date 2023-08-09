import java.awt.*;

public class Board {
    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
        // Implementation to check if the cell at (x, y) is valid
    }
    public void setCell(int x, int y, Color color) {
        // Implementation to set the cell at (x, y) with the specified color
    }
    private int width;
    private int height;
    private Color backgroundColor;

    public Board(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, width, height);
    }
}