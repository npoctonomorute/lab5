package lab_6.common.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RequestSender {

    public static final int SERVER_PORT = 2929;
    public static final String SERVER_HOST = "helios.cs.ifmo.ru"; //helios.cs.ifmo.ru | localhost

    public static Response send(Request request) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);

            String message = Serializer.serializeToString(request);
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            socket.send(sendPacket);

            byte[] receiveData = new byte[8192];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String serializedResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            return (Response) Serializer.deserializeFromString(serializedResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
