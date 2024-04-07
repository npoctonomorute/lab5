package Commands;

import Data.Collection;

public class Help implements Command {

    private final Collection collection;

    public Help(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {

    }
}
