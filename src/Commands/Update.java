package Commands;

import Data.CollectionManager;

public class Update implements Command {

    CollectionManager collection;
    /**
     *
     */
    @Override
    public void execute(String arg) {
        System.out.println(arg);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("update - обновить значение элемента коллекции, id которого равен заданному");
    }
}
