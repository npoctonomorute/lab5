package lab_6.server;

import lab_6.common.network.Request;
import lab_6.common.network.Response;
import lab_6.common.network.Serializer;
import lab_6.server.JSON.JsonParser;
import lab_6.server.app.Router;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerMain {
    public static final int SERVER_PORT = 9876;
    public static final String STORAGE_FILE = "amogus.json";

    public static void main(String[] args) {
        JsonParser parser = new JsonParser(STORAGE_FILE);
        parser.parse();
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

                System.out.println("Получено: " + request.getData());

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
}
