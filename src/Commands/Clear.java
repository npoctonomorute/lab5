package Commands;

import Data.Collection;

public class Clear implements Command {
    private final Collection collection;

    public Clear(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] string) {
        collection.clear();
        System.out.println("Коллекция очищена.");
    }
}
