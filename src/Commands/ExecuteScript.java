package Commands;

import Data.Collection;

public class ExecuteScript implements Command {

    private final Collection collection;

    public ExecuteScript(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {

    }
}
