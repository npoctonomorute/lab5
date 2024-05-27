package lab_6.client.Commands;

import lab_6.client.Commands.Generators.WorkerGeneration;
import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.server.CollectionManager;

import java.util.HashMap;

public class RemoveGreater implements Command {

    /**
     *
     */
    @Override
    public void execute(String arg) {
        WorkerGeneration workerGeneration = new WorkerGeneration();
        WorkerDTO workerDTO = workerGeneration.execute();
        Worker worker = new Worker(CollectionManager.generateId(), workerDTO);
        HashMap<Long, Worker> coll = CollectionManager.getMap();
        for (Worker newWorker : coll.values()) {
            if (worker.compareTo(newWorker) < 0) {
                CollectionManager.removeKey(newWorker.getId());
                System.out.println("Работяга с ID = " + newWorker.getId() + " устранен, у него слишком большая зарплата!");
            } else {
                System.out.println("Работяга с ID = " + newWorker.getId() + " оставлен, его зарплата достаточно мала!");
            }
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
