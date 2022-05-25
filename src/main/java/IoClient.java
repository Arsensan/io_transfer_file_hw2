import java.io.*;
import java.net.Socket;

public class IoClient {
    static Socket socket;


    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\file.txt");
        System.out.println(file);

        try {
            socket = new Socket("localhost", 8189);
            System.out.println("Client started...");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(file);
            System.out.println("File sent...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
