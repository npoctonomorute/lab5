package lab_6.server;

import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class CollectionManager {
    private static HashMap<Long, Worker> collection = new HashMap<Long, Worker>();

    private static long lastId = 0;

    public static Collection<Worker> getAll() {
        return collection.values();
    }

    public static long generateId() {
        return ++lastId;
    }

    public boolean isEmpty() {
        return collection.isEmpty();
    }

    private static final Date initializationDate = new Date();

    public static void clear() {
        collection.clear();
    }

    public static void add(Worker worker) {
        collection.put(worker.getId(), worker);
    }

    public static void removeKey(long key) {
        collection.remove(key);
    }

    public static Worker update(long key, WorkerDTO dto) {
        Worker worker = new Worker(key, dto);
        collection.replace(key, worker);
        return worker;
    }

    public static Worker create(WorkerDTO dto) {
        Worker worker = new Worker(CollectionManager.generateId(), dto);
        collection.put(worker.getId(), worker);
        return worker;
    }

    public static String getType() {
        return (collection.getClass().getSimpleName());
    }

    public static HashMap<Long, Worker> getMap() {
        return collection;
    }

    public static void setMap(HashMap<Long, Worker> collection) {
        CollectionManager.collection = collection;
        collection.keySet().stream().max(Long::compareTo).ifPresent(id -> lastId = id);
    }

    public static Date getInitializationDate() {
        return initializationDate;
    }

    public static int getSize() {
        return collection.size();
    }
}
