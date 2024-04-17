package Commands;

import Data.Collection;

public class RemoveLower implements Command {

    Collection collection;

    /**
     *
     */
    @Override
    public void execute() {

    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("удалить из коллекции все элементы, меньшие, чем заданный");
    }
}
