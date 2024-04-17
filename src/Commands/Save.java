package Commands;

import Data.Collection;

public class Save implements Command {

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
        return ("save - сохранить коллекцию в файл");
    }
}
