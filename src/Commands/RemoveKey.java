package Commands;

import Data.Collection;

public class RemoveKey implements Command {

    Collection collection;


    /**
     *
     */
    @Override
    public void execute() {
        collection.removeKey();
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("удалить элемент из коллекции по его ключу");
    }
}
