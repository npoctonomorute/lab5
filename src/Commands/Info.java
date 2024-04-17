package Commands;

import Data.Collection;

public class Info implements Command {
    Collection collection;
    /**
     *
     */
    @Override
    public void execute() {
        System.out.println("Тип коллекции: " + collection.getType() + ", дата инициализации: " + collection.getInitializationDate() + ", размер коллекции: " + collection.getSize());
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
}
