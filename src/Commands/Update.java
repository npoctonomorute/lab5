package Commands;

import Data.Collection;

public class Update implements Command {

    private final Collection collection;

    public Update(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] key) {
        collection.update(Integer.parseInt(key[0]), key[1]);
    }
}
