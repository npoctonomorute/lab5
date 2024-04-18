package Commands;

import Data.CollectionManager;

public class FilterContainsName implements Command {

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
        return ("filter_contains_name - вывести элементы, значение поля name которых содержит заданную подстроку");
    }
}
