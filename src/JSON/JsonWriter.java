package JSON;

import App.Converter;
import Data.Worker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

public class JsonWriter {
    public void write(Collection<Worker> workers){

        String filepath = "./data.json";
        StringBuilder data = new StringBuilder();

        data.append("[\n");
        for (Worker worker : workers){
            String json = Converter.mapToJson(Converter.workerToMap(worker));
            data.append(Converter.tabJson(json));
        }
        data.deleteCharAt(data.length() - 1);
        data.append("\n]");

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filepath))){
            writer.write(data.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
