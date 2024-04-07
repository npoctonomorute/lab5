package Commands;

import Data.Collection;

public class RemoveAllByPosition implements Command {

    private final Collection collection;

    public RemoveAllByPosition(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {

    }
}
