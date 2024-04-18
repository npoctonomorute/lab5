package Commands;

import Data.CollectionManager;

public class RemoveLower implements Command {

    CollectionManager collection;

    /**
     *
     */
    @Override
    public void execute(String arg) {

    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_lower - удалить из коллекции все элементы, меньшие, чем заданный");
    }
}
