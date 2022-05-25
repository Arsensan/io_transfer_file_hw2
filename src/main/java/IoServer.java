import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class IoServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server is started...");
            Socket socket = serverSocket.accept();
            System.out.println("Client is connected...");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            try {
                File file = (File) objectInputStream.readObject();
                System.out.println(file);

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
