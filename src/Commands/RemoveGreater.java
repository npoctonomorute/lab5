package Commands;

import Data.CollectionManager;
import Data.Worker;

import java.util.HashMap;

public class RemoveGreater implements Command {

    CollectionManager collection;

    /**
     *
     */
    @Override
    public void execute(String arg) {
        Worker work = null; // TODO: fix
        HashMap<Long, Worker> wrkr = collection.getMap();
        for (Long key : wrkr.keySet()){
            int res = work.compareTo(wrkr.get(key)); //todo: add exceptions
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_greater - удалить из коллекции все элементы, превышающие заданный");
    }
}
