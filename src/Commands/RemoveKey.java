package Commands;

import Data.Collection;

public class RemoveKey implements Command {

    private final Collection collection;

    public RemoveKey(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {
        collection.removeKey(Integer.parseInt(str[0]));
    }
}
