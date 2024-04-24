package Commands;

import Commands.Generators.PersonGeneration;
import Data.*;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterByPerson implements Command {

    CollectionManager collection;

    /**
     *
     */
    @Override
    public void execute(String arg) {

        System.out.println("Начинается поиск...");

        PersonGeneration personGeneration = new PersonGeneration();
        Person person = personGeneration.execute(arg);

        /*String[] parts = arg.split(" ", 7);

        String birthdayStr = parts[0];
        DateFormat formatter2 = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday2;
        try {
            birthday2 = formatter2.parse(birthdayStr);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }

        String colorCode = parts[1];
        Color color = Color.values()[Integer.parseInt(colorCode)];

        String countryCode = parts[2];
        Country country = Country.values()[Integer.parseInt(countryCode)];

        Double x = Double.parseDouble(parts[3]);
        Double y = Double.parseDouble(parts[4]);
        Double z = Double.parseDouble(parts[5]);
        String locName = parts[6];

        Person person = new Person(birthday2,
                color,
                country,
                new Location(x, y, z, locName));

         */

        HashMap<Long, Worker> coll = CollectionManager.getMap();
        boolean flag = false;
        ArrayList<Worker> workers = new ArrayList<>();
        for (Worker worker : coll.values()){
            Person listPerson = worker.getPerson();
            /*if (listPerson.getBirthday() == person.getBirthday()){
                if (listPerson.getHairColor() == person.getHairColor()){
                    if (listPerson.getNationality() == person.getNationality()){
                        if (listPerson.getLocation().getX().equals(person.getLocation().getX())){
                            flag = true;
                            workers.add(worker);
                        }
                    }
                }
            }
             */
            if (listPerson.equals(person)){
                flag = true;
                workers.add(worker);
            }
        }
        if (flag){
            System.out.println("Такие элементы существуют!");
            System.out.println(workers);
        }else{
            System.out.println("Oopsie! Нет таких элементов :(");
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
