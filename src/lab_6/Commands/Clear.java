package lab_6.Commands;

import lab_6.App.CollectionManager;

public class Clear implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        CollectionManager.clear();
        System.out.println("Коллекция очищена.");
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("clear - очистить коллекцию");
    }
}
