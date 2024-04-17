package Commands;

import Data.Collection;

import java.util.Scanner;

public class RemoveKey implements Command {

    Collection collection;


    /**
     *
     */
    @Override
    public void execute() {
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
