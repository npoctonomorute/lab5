package Commands;

import App.CollectionManager;

public class Save implements Command {

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
        return ("save - сохранить коллекцию в файл");
    }
}
