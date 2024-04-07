package Commands;

import Data.Collection;

public class RemoveGreater implements Command {

    private final Collection collection;

    public RemoveGreater(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {

    }
}
