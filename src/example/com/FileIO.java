package example.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    private String filePath;

    public FileIO(String filePath) {
        this.filePath = filePath;
    }

    public String readFromFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileIO fileIO = new FileIO("example.txt");

        // Write data to the file
        String data = "Hello, FileIO!";
        fileIO.writeToFile(data);

        // Read data from the file
        String content = fileIO.readFromFile();
        System.out.println("File content:\n" + content);
    }
}
