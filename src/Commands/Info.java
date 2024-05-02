package Commands;

import App.CollectionManager;

public class Info implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        System.out.println("Тип коллекции: " + CollectionManager.getType() + ", дата инициализации: " + CollectionManager.getInitializationDate() + ", размер коллекции: " + CollectionManager.getSize());
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
}
