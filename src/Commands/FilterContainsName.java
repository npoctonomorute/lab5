package Commands;

import Data.Collection;

public class FilterContainsName implements Command {

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
        return ("filter_contains_name - вывести элементы, значение поля name которых содержит заданную подстроку");
    }
}
