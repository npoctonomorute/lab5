package lab_6.client.Commands;

import lab_6.client.App.RequestSender;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;

public class Clear implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        Request request = new Request(ActionAlias.CLEAR);
        Response response = RequestSender.send(request);
        Integer deleted = (Integer) response.getData();
        System.out.println("Ваши работяги выпилились. Их было - " + deleted);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("clear - очистить коллекцию");
    }
}
