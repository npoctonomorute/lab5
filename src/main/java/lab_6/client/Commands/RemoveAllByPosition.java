package lab_6.client.Commands;

import lab_6.client.App.RequestSender;
import lab_6.common.Classes.Position;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;

public class RemoveAllByPosition implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        Position position = Position.values()[Integer.parseInt(arg)];
        Request request = new Request(ActionAlias.REMOVE_BY_POSITION, position);
        Response response = RequestSender.send(request);
        Integer removed = (Integer) response.getData();
        if (removed > 0) {
            System.out.println("Работяги с заданным position существуют, поэтому мы их уже удалили! Сокращено работяг: " + removed);
        } else {
            System.out.println("Oopsie! Нет работяг с заданным position :(");
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return "remove_all_by_position - удалить из коллекции все элементы, значение поля position которого эквивалентно заданному";
    }
}
