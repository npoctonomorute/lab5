package Commands;

import Data.CollectionManager;

import java.util.Scanner;

public class RemoveKey implements Command {

    CollectionManager collection;


    /**
     *
     */
    @Override
    public void execute(String arg) {
        Scanner sc = new Scanner(System.in);
        collection.removeKey(sc.nextInt());
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_key - удалить элемент из коллекции по его ключу");
    }
}
