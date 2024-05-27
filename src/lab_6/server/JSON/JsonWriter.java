package lab_6.server.JSON;

import com.google.gson.Gson;
import lab_6.server.CollectionManager;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public static final String STORAGE_FILE = "amogus.json";

    private final CollectionManager collection;
    private final String fileName;

    public JsonWriter(CollectionManager collection, String fileName) {
        this.collection = collection;
        this.fileName = fileName;
    }

    public static void save() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(CollectionManager.getAll());
            FileWriter fileWriter = new FileWriter("amogus.json");
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
