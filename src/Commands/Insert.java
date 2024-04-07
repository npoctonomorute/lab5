package Commands;

import Data.Collection;

public class Insert implements Command {

    private final Collection collection;

    public Insert(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {

    }
}
