package Commands;

import Data.Collection;

public class Exit implements Command {

    private final Collection collection;

    public Exit(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {

    }
}
