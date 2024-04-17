package Commands;

import Data.Collection;

public class RemoveAllByPosition implements Command {
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
        return "удалить из коллекции все элементы, значение поля position которого эквивалентно заданному";
    }
}
