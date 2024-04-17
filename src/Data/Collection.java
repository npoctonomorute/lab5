package Data;

import java.util.Date;
import java.util.HashMap;

public class Collection {
    HashMap<Integer, Worker> collection = new HashMap<>();
    private final Date initializationDate = new Date();
    public void clear() {
        collection.clear();
    }
    public void add(Worker worker){
        collection.put(collection.size() + 1, worker);
    }
    public void removeKey(int key){
        collection.remove(key);
    }
    public void show(){
        System.out.println(collection);
    }
    public void insert(int key, Worker value){
        collection.put(key, value);
    }
    public void update(int key, Worker value){
        collection.replace(key, value);
    }
    public String getType() {
        return (collection.getClass().getSimpleName());
    }

    public HashMap<Integer, Worker> getMap(){
        return collection;
    }

    public Date getInitializationDate() {
        return initializationDate;
    }
    public int getSize(){
        return collection.size();
    }
}
