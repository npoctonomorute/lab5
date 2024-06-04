package lab_6.client.Commands;

import lab_6.client.Commands.Generators.WorkerGeneration;
import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.RequestSender;
import lab_6.common.network.Response;

public class Update implements Command {

    @Override
    public void execute(String arg) {
        System.out.println("Начинается замена работяги по ключу!!!");
        long key = Long.parseLong(arg);
        WorkerGeneration workerGeneration = new WorkerGeneration();
        WorkerDTO workerDTO = workerGeneration.execute();
        workerDTO.setId(key);
        Request request = new Request(ActionAlias.UPDATE, workerDTO);
        Response response = RequestSender.send(request);
        Worker worker = (Worker) response.getData();
        System.out.println("Работяга создан и заменил предыдущего работягу! (без негатива)");
        System.out.println(worker);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("update - обновить значение элемента коллекции, id которого равен заданному");
    }
}
