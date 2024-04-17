package Commands;

import Data.Collection;

public class Exit implements Command {
    /**
     *
     */
    @Override
    public void execute() {
        System.exit(0);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return "exit - завершить программу (без сохранения в файл)";
    }
}
