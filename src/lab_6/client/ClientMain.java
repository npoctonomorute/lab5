package lab_6.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientMain {
    public static void main(String[] args) throws IOException/*throws FileNotFoundException*/ {
        int port = 22335;
        DatagramChannel datagramChannel = DatagramChannel.open();
        //datagramChannel.configureBlocking(false);
        InetSocketAddress servAdr = new InetSocketAddress(InetAddress.getLocalHost(), port);
        ByteBuffer buffer = null;

//        Worker worker = new Worker();
//        ClientRequest request = new ClientRequest();
//        request.setCommandName("add");
//        request.setWorker(worker);

        datagramChannel.send(buffer, servAdr);
        buffer.clear();

        buffer = ByteBuffer.allocate(30);
        datagramChannel.receive(buffer);
        System.out.println(buffer.array());

//        if (args.length == 0) {
//            System.out.println("Не указан файл с коллекцией");
//            System.exit(0);
//        }
//
//
//        CollectionManager collection = null;
//        try {
//            JsonParser parser = new JsonParser(args[0]);
//            collection = parser.parse();
//        } catch (NullPointerException e) {
//            System.out.println("Этот файл пустой, не могу работать с ним.");
//            System.exit(0);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Файл не найден");
//            System.exit(0);
//        }
//
//        //JsonParser parser = new JsonParser(args[0]);
//        System.out.println(collection.getMap());
//        System.out.println("привет от амогусов ඞඞඞඞඞඞඞඞඞඞඞඞඞ");
//        Scanner sc = new Scanner(System.in);
//        AppContainer.setSc(sc);
//        Invoker invoker = new Invoker();
//        while (sc.hasNextLine()) {
//            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
//            invoker.invoke(line);
//        }
    }
}
