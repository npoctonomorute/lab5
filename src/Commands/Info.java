package Commands;

import Data.CollectionManager;

public class Info implements Command {
    CollectionManager collection;
    /**
     *
     */
    @Override
    public void execute(String arg) {
        System.out.println("Тип коллекции: " + collection.getType() + ", дата инициализации: " + collection.getInitializationDate() + ", размер коллекции: " + collection.getSize());
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
}
