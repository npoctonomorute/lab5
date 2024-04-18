package Commands;

import Data.CollectionManager;

public class FilterByPerson implements Command {

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
        return "filter_by_person - вывести элементы, значение поля person которых равно заданному";
    }
}
