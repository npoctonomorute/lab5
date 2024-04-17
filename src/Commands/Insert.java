package Commands;

import Data.Collection;
import Data.Worker;

public class Insert implements Command {

    Collection collection;

    /**
     *
     */
    @Override
    public void execute() {
        collection.add();
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return "insert - добавить новый элемент с заданным ключом";
    }
}
