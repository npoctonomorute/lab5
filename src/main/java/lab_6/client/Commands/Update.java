package lab_6.client.Commands;

import lab_6.client.App.ClientAppContainer;
import lab_6.client.App.RequestSender;
import lab_6.client.Commands.Generators.WorkerGeneration;
import lab_6.common.Classes.Worker;
import lab_6.common.Classes.dto.WorkerDTO;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;

public class Update implements Command {

    @Override
    public void execute(String arg) {
        if (arg == null || arg.isEmpty()) {
            System.out.println("Необходимо ID работяги");
            return;
        }
        long key;
        try {
            key = Long.parseLong(arg);
        } catch (NumberFormatException e) {
            System.out.println("ID работяги должно быть целым числом");
            return;
        }
        System.out.println("Начинается замена работяги по ключу!!!");
        WorkerGeneration workerGeneration = new WorkerGeneration();
        WorkerDTO workerDTO = workerGeneration.execute();
        workerDTO.setId(key);
        Request request = new Request(ActionAlias.UPDATE, workerDTO);
        Response response = RequestSender.send(request);
        Worker worker = (Worker) response.getData();
        if (worker != null) {
            if (worker.getOwnerLogin().equals(ClientAppContainer.getUser().getLogin())) {
                System.out.println("Работяга обновлен - " + worker);
            } else {
                System.out.println("Это не ваш работяга");
            }
        } else {
            System.out.println("Такого ID работяги нет");
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("update - обновить значение элемента коллекции, id которого равен заданному");
    }
}
