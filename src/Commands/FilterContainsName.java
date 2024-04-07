package Commands;

import Data.Collection;

public class FilterContainsName implements Command {

    private final Collection collection;

    public FilterContainsName(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {

    }
}
