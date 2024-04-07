package Data;

import java.util.HashMap;

public class Collection {
    private final HashMap<Integer, String> collection = new HashMap<>();
    public void clear() {
        collection.clear();
    }
    public void removeKey(int key){
        collection.remove(key);
    }
    public void show(){
        System.out.println(collection);
    }
}
