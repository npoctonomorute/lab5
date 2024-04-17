package Commands;

import Data.Collection;

public class Show implements Command {

    Collection collection;

    /**
     *
     */
    @Override
    public void execute() {
        collection.show();
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
