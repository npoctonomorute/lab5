package Commands;

import Data.Collection;

public class Update implements Command {

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
        return ("update - обновить значение элемента коллекции, id которого равен заданному");
    }
}
