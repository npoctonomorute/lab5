package Commands;

import Data.Collection;

public class ReplaceIfGreater implements Command {

    Collection collection;

    /**
     *
     */
    @Override
    public void execute() {

    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("replace_if_greater - заменить значение по ключу, если новое значение больше старого");
    }
}
