package JSON;

import App.CollectionManager;
import Data.Worker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Date;
import java.util.List;

public class JsonParser {
    private final String fileName;
    private final String test = "";
    public JsonParser(String fileName) {
        this.fileName = fileName;
    }
    public CollectionManager parse() throws FileNotFoundException {
        Gson gson = new Gson();
        //BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedReader reader = new BufferedReader(new StringReader(test));
        List<Worker> workers = gson.fromJson(reader, new TypeToken<List<Worker>>(){}.getType());
        CollectionManager collection = new CollectionManager();

        for (Worker worker : workers) {
            worker.setId(CollectionManager.generateId());
            worker.setCreationDate(new Date());
        }
        return collection;
    }
}
