package JSON;

import Data.Worker;
import Data.WorkerParsedData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import App.Converter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class JsonParser {
    public Collection<Worker> parse() {
        String filepath = "./data.json";
        Collection<WorkerParsedData> collection;
        Collection<Worker> workers = new HashSet<>();

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            collection = gson.fromJson(
                    new InputStreamReader(bis),
                    new TypeToken<Collection<WorkerParsedData>>() {
                    }.getType()
            );

            for (WorkerParsedData workerParsedData : collection){
                workers.add(Converter.parsedToWorker(workerParsedData));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }

        return flats;
    }
}
