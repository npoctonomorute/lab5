package JSON;

import App.CollectionManager;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    private final CollectionManager collection;
    private final String fileName;

    public JsonWriter(CollectionManager collection, String fileName) {
        this.collection = collection;
        this.fileName = fileName;
    }

    public void write() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(CollectionManager.getAll());
        FileWriter fileWriter = new FileWriter("amogus.json");
        fileWriter.write(json);
        fileWriter.close();
    }
}
