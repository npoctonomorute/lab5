package Commands;

import Data.Collection;

public class RemoveLower implements Command {

    private final Collection collection;

    public RemoveLower(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {

    }
}
