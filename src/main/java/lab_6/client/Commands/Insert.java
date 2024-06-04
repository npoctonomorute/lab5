package lab_6.client.Commands;

import lab_6.client.App.RequestSender;
import lab_6.client.Commands.Generators.WorkerGeneration;
import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;

public class Insert implements Command {

    @Override
    public void execute(String arg) {
        System.out.println("Начинается создание работяги!!!");
        WorkerGeneration workerGeneration = new WorkerGeneration();
        WorkerDTO workerDTO = workerGeneration.execute();
        Request request = new Request(ActionAlias.ADD, workerDTO);
        Response response = RequestSender.send(request);
        Worker worker = (Worker) response.getData();
        System.out.println("Работяга создан и добавлен!");
        System.out.println(worker);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return "insert - добавить новый элемент с заданным ключом";
    }
}
