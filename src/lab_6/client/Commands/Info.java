package lab_6.client.Commands;

import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.RequestSender;
import lab_6.common.network.Response;

public class Info implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        Request request = new Request(ActionAlias.INFO);
        Response response = RequestSender.send(request);
        String result = (String) response.getData();
        System.out.println(result);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
}
