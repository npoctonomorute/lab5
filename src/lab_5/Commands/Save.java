package lab_5.Commands;

import lab_5.App.CollectionManager;
import lab_5.JSON.JsonWriter;

import java.io.IOException;

public class Save implements Command {

    public Save() {
    }
    CollectionManager collection;
    /**
     *
     */
    @Override
    public void execute(String arg) {
        JsonWriter writer = new JsonWriter(collection, "amogus.json");
        try {
            writer.write();
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