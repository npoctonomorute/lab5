package lab_6.client.Commands;

import lab_6.client.Commands.Generators.WorkerGeneration;
import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.server.CollectionManager;

public class ReplaceIfGreater implements Command {

    @Override
    public void execute(String arg) {
        System.out.println("Начинается замена работяги по ключу (но только если у него больше зарплата)!!!");
        long key1 = Long.parseLong(arg);
        WorkerGeneration workerGeneration = new WorkerGeneration();
        WorkerDTO workerDTO = workerGeneration.execute();
        Worker worker = new Worker(CollectionManager.generateId(), workerDTO);
        Worker oldWorker = CollectionManager.getMap().get(key1);
        if (worker.compareTo(oldWorker) < 0) {
//            CollectionManager.removeKey(key1);
//            CollectionManager.add(worker);
            System.out.println("Работяга создан и все таки заменил предыдущего работягу! (без негатива)");
        } else {
            System.out.println("Замена работяги не удалась, его зарплата оказалась маленькой(");
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("replace_if_greater - заменить значение по ключу, если новое значение больше старого");
    }
}
