package Commands;

import Data.CollectionManager;

public class ReplaceIfGreater implements Command {

    CollectionManager collection;

    /**
     *
     */
    @Override
    public void execute(String arg) {

    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("replace_if_greater - заменить значение по ключу, если новое значение больше старого");
    }
}
