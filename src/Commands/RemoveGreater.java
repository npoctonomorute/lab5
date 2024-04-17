package Commands;

import Data.Collection;
import Data.Worker;

import java.util.HashMap;

public class RemoveGreater implements Command {

    Collection collection;

    /**
     *
     */
    @Override
    public void execute() {
        Worker work = null; // TODO: fix
        HashMap<Integer, Worker> wrkr = collection.getMap();
        for (Integer key : wrkr.keySet()){
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
