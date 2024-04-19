package Commands;

import Data.CollectionManager;
import Data.Worker;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterContainsName implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        System.out.println("Начинается поиск...");
        HashMap<Long, Worker> coll = CollectionManager.getMap();
        boolean flag = false;
        ArrayList<Worker> workers = new ArrayList<>();
        for (Worker worker : coll.values()){
            String name = worker.getName();
            long id = worker.getId();
            if (name.contains(arg)){
                flag = true;
                workers.add(worker);
            }
        }
        if (flag){
            System.out.println("Да, существует такой элемент!");
            System.out.println(workers);
        }else{
            System.out.println("Oopsie! Нет такой подстроки :(");
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("filter_contains_name - вывести элементы, значение поля name которых содержит заданную подстроку");
    }
}
