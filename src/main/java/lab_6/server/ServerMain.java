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
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

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
        ExecutorService forkJoinPool = new ForkJoinPool();
        ExecutorService fixedThreadPool1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ExecutorService fixedThreadPool2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("Запуск сервера...");
        forkJoinPool.submit(() -> {
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

                    fixedThreadPool1.submit(() -> {
                        Response response = router.resolve(request);

                        fixedThreadPool2.submit(() -> {
                            try {
                                InetAddress clientAddress = receivePacket.getAddress();
                                int clientPort = receivePacket.getPort();
                                String responseText = Serializer.serializeToString(response);
                                byte[] responseData = responseText.getBytes();
                                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                                socket.send(sendPacket);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    });
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("exit")) {
                break;
            } else {
                System.out.println("Введите команду exit для остановки сервера");
            }
        }
        System.out.println("Сервер остановлен");
        forkJoinPool.shutdown();
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
