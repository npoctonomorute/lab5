package Commands;

import Data.Collection;

public class FilterByPerson implements Command {

    private final Collection collection;

    public FilterByPerson(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {

    }
}
