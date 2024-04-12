package Commands;

import Data.Collection;
import Data.Worker;

import java.util.HashMap;

public class RemoveGreater implements Command {

    private final Collection collection;

    public RemoveGreater(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] str) {
        Worker work = null; // TODO: fix
        HashMap<Integer, Worker> lol = collection.getMap();
        for (Integer key : lol.keySet()){
            int res = work.compareTo(lol.get(key)); //todo: add exceptions
        }
    }
}
