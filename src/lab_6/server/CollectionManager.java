package lab_6.server;

import lab_6.common.Classes.Person;
import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionManager implements Iterator {
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


        // test
//        for (Worker w : new CollectionManager()) {
//
//        }
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

    //TODO: if -> stream api

    public static String getType() {
        return (collection.getClass().getSimpleName());
    }

    public static HashMap<Long, Worker> getMap() {
        return collection;
    }

    public static ArrayList<Worker> filterByPerson(Person person) {
        HashMap<Long, Worker> coll = CollectionManager.getMap();
        return coll.values().stream()
                .filter(worker -> worker.getPerson().equals(person))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void setMap(HashMap<Long, Worker> collection) {
        CollectionManager.collection = collection;
        collection.keySet().stream().max(Long::compareTo).ifPresent(id -> lastId = id);
    }

    public static Integer removeLower(WorkerDTO workerDTO) {
        Worker worker = new Worker(generateId(), workerDTO);
        HashMap<Long, Worker> collection = CollectionManager.getMap();
        List<Long> idsToRemove = collection.values().stream()
                .filter(newWorker -> worker.compareTo(newWorker) > 0)
                .map(Worker::getId)
                .collect(Collectors.toList());
        idsToRemove.forEach(CollectionManager::removeKey);

        return idsToRemove.size();
    }

    public static Integer removeGreater(WorkerDTO workerDTO) {
        Worker worker = new Worker(generateId(), workerDTO);
        HashMap<Long, Worker> collection = CollectionManager.getMap();
        List<Long> idsToRemove = collection.values().stream()
                .filter(newWorker -> worker.compareTo(newWorker) < 0)
                .map(Worker::getId)
                .collect(Collectors.toList());
        idsToRemove.forEach(CollectionManager::removeKey);

        return idsToRemove.size();
    }


    public static Date getInitializationDate() {
        return initializationDate;
    }

    public static int getSize() {
        return collection.size();
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        return null;
    }
}
