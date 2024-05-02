package Commands;

import App.CollectionManager;
import JSON.JsonWriter;

import java.io.IOException;

public class Save implements Command {

    public Save() {
    }

    /**
     *
     */
    @Override
    public void execute(String arg) {
        JsonWriter writer = new JsonWriter();
        try {
            writer.writeToJson();
            System.out.println("Коллекция сохранена в amogus.json");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в amogus.json: " + e.getMessage());
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("save - сохранить коллекцию в файл");
    }
}
