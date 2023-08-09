import java.awt.*;

public class Board {
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