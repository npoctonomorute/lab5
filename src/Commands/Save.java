package Commands;

import Data.Collection;

public class Save implements Command {

    private final Collection collection;

    public Save(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {

    }
}
