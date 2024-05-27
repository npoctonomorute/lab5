package lab_6.client.Commands;

import lab_6.client.App.AppContainer;
import lab_6.server.CollectionManager;

import java.util.Scanner;

public class RemoveKey implements Command {


    /**
     * @return удалить элемент из коллекции по его ключу
     */
    @Override
    public void execute(String arg) {
        Scanner sc = AppContainer.getSc();
        CollectionManager.removeKey(Long.parseLong(arg));
        System.out.println("Элемент с ключом " + arg + " удален.");
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_key - удалить элемент из коллекции по его ключу");
    }
}
