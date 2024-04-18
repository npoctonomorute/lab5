package Commands;

import Data.CollectionManager;

public class RemoveAllByPosition implements Command {
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
        return "remove_all_by_position - удалить из коллекции все элементы, значение поля position которого эквивалентно заданному";
    }
}
