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
        return "remove_all_by_position - удалить из коллекции все элементы, значение поля position которого эквивалентно заданному";
    }
}
