package lab_6.server;

import lab_6.common.Classes.Person;
import lab_6.common.Classes.Position;
import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;

import java.util.*;

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
        Worker worker = new Worker(generateId(), dto);
        collection.put(worker.getId(), worker);
        return worker;
    }

    public static String getType() {
        return (collection.getClass().getSimpleName());
    }

    public static HashMap<Long, Worker> getMap() {
        return collection;
    }

    public static ArrayList<Worker> filterByPerson(Person person) {
        HashMap<Long, Worker> coll = CollectionManager.getMap();
        ArrayList<Worker> workers = new ArrayList<>();
        for (Worker worker : coll.values()) {
            Person listPerson = worker.getPerson();
            if (listPerson.equals(person)) {
                workers.add(worker);
            }
        }
        return workers;
    }

    public static void setMap(HashMap<Long, Worker> collection) {
        CollectionManager.collection = collection;
        collection.keySet().stream().max(Long::compareTo).ifPresent(id -> lastId = id);
    }

    public static Integer removeLower(WorkerDTO workerDTO) {
        Worker worker = new Worker(generateId(), workerDTO);
        int removed = 0;
        for (Worker newWorker : collection.values()) {
            if (worker.compareTo(newWorker) > 0) {
                CollectionManager.removeKey(newWorker.getId());
                removed++;
            }
        }
        return removed;
    }

    public static Integer removeGreater(WorkerDTO workerDTO) {
        Worker worker = new Worker(generateId(), workerDTO);
        int removed = 0;
        for (Worker newWorker : collection.values()) {
            if (worker.compareTo(newWorker) < 0) {
                CollectionManager.removeKey(newWorker.getId());
                removed++;
            }
        }
        return removed;
    }

    public static Integer removeByPosition(Position position) {
        int removed = 0;
        for (Worker worker : collection.values()) {
            Position listPosition = worker.getPosition();
            if (listPosition.equals(position)) {
                removed++;
                CollectionManager.removeKey(worker.getId());
            }
        }
        return removed;
    }

    public static Date getInitializationDate() {
        return initializationDate;
    }

    public static int getSize() {
        return collection.size();
    }
}
