package lab_6.client.Commands;

import lab_6.client.App.RequestSender;
import lab_6.client.Commands.Generators.PersonGeneration;
import lab_6.common.Classes.Person;
import lab_6.common.Classes.Worker;
import lab_6.common.network.ActionAlias;
import lab_6.common.network.Request;
import lab_6.common.network.Response;
import lab_6.server.collection.CollectionManager;

import java.util.List;

public class FilterByPerson implements Command {

    CollectionManager collection;

    /**
     *
     */
    @Override
    public void execute(String arg) {
        PersonGeneration personGeneration = new PersonGeneration();
        Person person = personGeneration.execute(arg);
        Request request = new Request(ActionAlias.FILTER_BY_PERSON, person);
        Response response = RequestSender.send(request);
        List<Worker> workers = (List<Worker>) response.getData();
        if (workers.isEmpty()) {
            System.out.println("Работяги не пришли");
        } else {
            for (Worker worker : workers) {
                System.out.println(worker.toString());
            }
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return "filter_by_person - вывести элементы, значение поля person которых равно заданному (задать person можно через пробел введя *дата рождения, номер цвета волос, номер национальности, координата по x, координата по y, координата по z, название локации*)";
    }
}
