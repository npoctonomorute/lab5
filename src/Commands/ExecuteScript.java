package Commands;

import Data.Collection;

public class ExecuteScript implements Command {

    private final Collection collection;

    public ExecuteScript(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {

    }

    @Override
    public String description() {
        return "execute_script - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
