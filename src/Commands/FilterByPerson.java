package Commands;

import Data.Collection;

public class FilterByPerson implements Command {

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
        return "вывести элементы, значение поля person которых равно заданному";
    }
}
