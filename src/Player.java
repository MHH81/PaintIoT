import java.awt.*;

public class Player {
    private int x;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // other methods

    private int y;
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    private Color color;
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Player(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 20, 20);
    }
    public void update() {
        // Perform any necessary updates to the player's state
        // For example, you could update the player's position based on its velocity or perform any other logic here
    }
}