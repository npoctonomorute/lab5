package Commands;

import Data.Collection;

public class Info implements Command {

    private final Collection collection;

    public Info(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {

    }
}
