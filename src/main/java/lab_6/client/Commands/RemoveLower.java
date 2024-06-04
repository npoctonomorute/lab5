package lab_6.client.Commands;

import lab_6.client.App.RequestSender;
import lab_6.client.Commands.Generators.WorkerGeneration;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;

public class RemoveLower implements Command {

    @Override
    public void execute(String arg) {
        System.out.println("Начинается генерации работяги для сравнения!!!");
        WorkerGeneration workerGeneration = new WorkerGeneration();
        WorkerDTO workerDTO = workerGeneration.execute();
        Request request = new Request(ActionAlias.REMOVE_LOWER, workerDTO);
        Response response = RequestSender.send(request);
        Integer removed = (Integer) response.getData();
        System.out.println("Сокращено работяг: " + removed);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_lower - удалить из коллекции все элементы, меньшие, чем заданный");
    }
}
