package lab_5.Commands;

import lab_5.App.CollectionManager;

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