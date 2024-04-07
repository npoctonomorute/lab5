package Commands;

import Data.Collection;

public class Show implements Command {

    private final Collection collection;

    public Show(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String string) {
        collection.show();
    }
}
