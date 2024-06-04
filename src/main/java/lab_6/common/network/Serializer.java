package lab_6.common.network;

import java.io.*;
import java.util.Base64;

public class Serializer {
    public static String serializeToString(Object o) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }

    public static Object deserializeFromString(String serialized) {
        byte[] decodedData = Base64.getDecoder().decode(serialized);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decodedData))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
