import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Networking {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private boolean isServer;

    public Networking(boolean isServer) {
        this.isServer = isServer;
        if (isServer) {
            setupServer();
        } else {
            setupClient();
        }
    }

    private void setupServer() {
        try {
            serverSocket = new ServerSocket(1234); // Example: Use port 1234 for server socket
            clientSocket = serverSocket.accept();
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupClient() {
        try {
            clientSocket = new Socket("localhost", 1234); // Example: Connect to localhost on port 1234
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(Object data) {
        try {
            outputStream.writeObject(data);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receiveData() {
        Object data = null;
        try {
            data = inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void close() {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Networking server = new Networking(true);
        Networking client = new Networking(false);

        // Example usage:
        // Server sends a message to the client
        server.sendData("Hello from server!");

        // Client receives the message from the server
        Object receivedData = client.receiveData();
        if (receivedData != null) {
            System.out.println("Received data: " + receivedData.toString());
        }

        // Close the connections
        server.close();
        client.close();
    }
}