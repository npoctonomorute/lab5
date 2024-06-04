package lab_6.client.Commands;

import lab_6.client.App.RequestSender;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;

public class RemoveKey implements Command {


    /**
     * @return удалить элемент из коллекции по его ключу
     */
    @Override
    public void execute(String arg) {
        Request request = new Request(ActionAlias.REMOVE, Long.parseLong(arg));
        Response send = RequestSender.send(request);
        Boolean removed = (Boolean) send.getData();
        if (removed == null) {
            System.out.println("Такого работяги и не было");
        } else if (removed) {
            System.out.println("Работяга под номером " + arg + " выпилился.");
        } else {
            System.out.println("Это не ваш работяга");
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_key - удалить элемент из коллекции по его ключу");
    }
}
