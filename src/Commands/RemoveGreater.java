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
        HashMap<Integer, Worker> lol = collection.getMap();
        for (Integer key : lol.keySet()){
            int res = work.compareTo(lol.get(key)); //todo: add exceptions
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("удалить из коллекции все элементы, превышающие заданный");
    }
}
