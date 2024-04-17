package Commands;

import Data.Collection;

public class Insert implements Command {

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
        return "добавить новый элемент с заданным ключом";
    }
}
