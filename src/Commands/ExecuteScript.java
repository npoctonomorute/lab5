package Commands;

import Data.CollectionManager;

public class ExecuteScript implements Command {

    private final CollectionManager collection;

    public ExecuteScript(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String arg) {

    }

    @Override
    public String description() {
        return "execute_script - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
