package lab_6.server;

import lab_6.common.network.Request;
import lab_6.common.network.Response;
import lab_6.common.network.Serializer;
import lab_6.server.app.Router;
import lab_6.server.app.ServerAppContainer;
import lab_6.server.collection.PostgresCollectionManager;
import lab_6.server.user.UserManager;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerMain {
    public static final int SERVER_PORT = 22335;
    public static final String STORAGE_FILE = "amogus.json";

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/makar";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        connectDB();
        runServer();
    }

    private static void runServer() {
        try (DatagramSocket socket = new DatagramSocket(SERVER_PORT)) {
            byte[] receiveData = new byte[8192];

            System.out.println("UDP сервер запущен...");
            Router router = new Router();

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                Request request = (Request) Serializer.deserializeFromString(message);

                System.out.println("Получен запрос: " + request.getActionAlias());
                if (request.getData() != null) {
                    System.out.println("Данные: " + request.getData());
                }
                System.out.println();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                Response response = router.resolve(request);
                String responseText = Serializer.serializeToString(response);
                byte[] responseData = responseText.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void connectDB() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ServerAppContainer.setConnection(connection);
            PostgresCollectionManager collectionManager = new PostgresCollectionManager(connection);
            ServerAppContainer.setCollectionManager(collectionManager);
            UserManager userManager = new UserManager(connection);
            ServerAppContainer.setUserManager(userManager);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
