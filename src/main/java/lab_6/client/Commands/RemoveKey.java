package lab_6.client.Commands;

import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.RequestSender;

public class RemoveKey implements Command {


    /**
     * @return удалить элемент из коллекции по его ключу
     */
    @Override
    public void execute(String arg) {
        Request request = new Request(ActionAlias.REMOVE, Long.parseLong(arg));
        RequestSender.send(request);
        System.out.println("Работяга под номером " + arg + " выпилился.");
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_key - удалить элемент из коллекции по его ключу");
    }
}
