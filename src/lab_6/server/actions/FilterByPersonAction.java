package lab_6.server.actions;

import lab_6.common.Classes.Person;
import lab_6.common.Classes.Worker;
import lab_6.common.network.Request;
import lab_6.server.CollectionManager;

import java.util.ArrayList;

public class FilterByPersonAction implements Action<ArrayList<Worker>> {
    /**
     * @param request
     * @return
     */
    @Override
    public ArrayList<Worker> execute(Request request) {
        Person person = (Person) request.getData();
        return CollectionManager.filterByPerson(person);
    }
}
