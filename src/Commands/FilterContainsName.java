package Commands;

import Data.CollectionManager;

public class FilterContainsName implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        for (int c = 0; c <= CollectionManager.getSize(); c++){

        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("filter_contains_name - вывести элементы, значение поля name которых содержит заданную подстроку");
    }
}
