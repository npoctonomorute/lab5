package Commands;

import App.CollectionManager;
import Data.*;

import java.util.HashMap;

public class RemoveAllByPosition implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {

        System.out.println("Начинается поиск...");

        String positionCode = arg;
        Position position = Position.values()[Integer.parseInt(positionCode)];

        HashMap<Long, Worker> coll = CollectionManager.getMap();
        boolean flag = false;
        for (Worker worker : coll.values()){
            Position listPosition = worker.getPosition();
            if (listPosition.equals(position)){
                flag = true;
                CollectionManager.removeKey(worker.getId());
            }
        }
        if (flag){
            System.out.println("Работяги с заданным position существуют, поэтому мы их уже удалили!");
        }else{
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
