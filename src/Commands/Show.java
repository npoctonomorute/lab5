package Commands;

import Data.CollectionManager;

public class Show implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        CollectionManager.show();
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
