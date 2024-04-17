package Commands;

import Data.Collection;

public class Clear implements Command {
    Collection collection;
    /**
     *
     */
    @Override
    public void execute() {
        collection.clear();
        System.out.println("Коллекция очищена.");
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("clear - очистить коллекцию");
    }
}
