package Commands;

import Data.Collection;

public class ReplaceIfGreater implements Command {

    private final Collection collection;

    public ReplaceIfGreater(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {

    }
}
