package App;

import Data.Worker;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class CollectionManager {
    private static final HashMap<Long, Worker> collection = new HashMap<Long, Worker>();

    private static long lastId = 0;
    public static Collection<Worker> getAll(){
        return collection.values();
    }

    public  static long generateId(){
        return ++lastId;
    }
    private static final Date initializationDate = new Date();
    public static void clear() {
        collection.clear();
    }
    public static void add(Worker worker){
        collection.put(worker.getId(), worker);
    }
    public static void removeKey(long key){
        collection.remove(key);
    }
    public static void show(){
        System.out.println(collection);
    }
    public static void update(long key, Worker value){
        collection.replace(key, value);
    }
    public static String getType() {
        return (collection.getClass().getSimpleName());
    }

    public static HashMap<Long, Worker> getMap(){
        return collection;
    }

    public static Date getInitializationDate() {
        return initializationDate;
    }
    public static int getSize(){
        return collection.size();
    }
}
