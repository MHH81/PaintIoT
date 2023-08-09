import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Game window properties
        int width = 800;
        int height = 600;

        // Create the game window
        JFrame frame = new JFrame("Paint.io");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // Or choose an appropriate layout manager

        // Create an instance of the Game class
        Game game = new Game();
        game.setBounds(0, 0, width, height);
        frame.add(game);

        // Make the game window visible
        frame.setVisible(true);

        // Start the game loop
        while (game.isRunning()) {
            game.update();  // Update the game state
            game.render();  // Render the graphics

            // Insert a small delay to control the game's frame rate
            try {
                Thread.sleep(16);  // Adjust the sleep time as desired
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}