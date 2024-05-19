package lab_5.Commands;

import lab_5.App.CollectionManager;

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
