package lab_6.client.Commands;

import lab_6.common.Classes.Worker;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.RequestSender;
import lab_6.common.network.Response;

import java.util.Map;

public class Show implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        Request request = new Request(ActionAlias.SHOW);
        Response response = RequestSender.send(request);
        Map<Long, Worker> workers = (Map<Long, Worker>) response.getData();
        if (workers.isEmpty()) {
            System.out.println("Работяги не пришли");
        } else {
            for (Worker worker : workers.values()) {
                System.out.println(worker.toString());
            }
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
