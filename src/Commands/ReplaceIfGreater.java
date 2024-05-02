package Commands;

import App.AppContainer;
import App.CollectionManager;
import Commands.Generators.WorkerGeneration;
import Data.*;

import java.util.Scanner;

public class ReplaceIfGreater implements Command {

    CollectionManager collection;
    /**
     *
     */
    Scanner sc = AppContainer.getSc();
    @Override
    public void execute(String arg) {
        System.out.println("Начинается замена работяги по ключу (но только если у него больше зарплата)!!!");
        long key1 = Long.parseLong(arg);
        WorkerGeneration workerGeneration = new WorkerGeneration();
        Worker worker = workerGeneration.execute();
        /*System.out.println("Введите имя: ");
        String name = sc.nextLine(); //todo: add exceptions if null
        System.out.println("Введите дату рождения в формате (ДД.ММ.ГГГГ): ");
        String birthdayStr = sc.nextLine();
        DateFormat formatter5 = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday5;
        try {
            birthday5 = formatter5.parse(birthdayStr);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }
        System.out.println("Введите номер цвета волос: ");
        for (int i = 0; i < Color.values().length; i++) {
            System.out.println(" • " + i + " - " + Color.values()[i]);
        }
        String colorCode = sc.nextLine();
        Color color = Color.values()[Integer.parseInt(colorCode)];


        System.out.println("Введите номер национальности: ");
        for (int i = 0; i < Country.values().length; i++) {
            System.out.println(" • " + i + " - " + Country.values()[i]);
        }
        String countryCode = sc.nextLine();
        Country country = Country.values()[Integer.parseInt(countryCode)];

        System.out.println("Введите координаты и имя локации: ");
        System.out.println("Введите координату по x: ");
        Double x = Double.parseDouble(sc.nextLine());
        System.out.println("Введите координату по y: ");
        Double y = Double.parseDouble(sc.nextLine());
        System.out.println("Введите координату по z: ");
        Double z = Double.parseDouble(sc.nextLine());
        System.out.println("Введите название локации: ");
        String locationName = sc.nextLine();
        System.out.println("Введите размер зарплаты: ");
        double salary = Double.parseDouble(sc.nextLine());
        System.out.println("Введите номер профессии: ");
        for (int i = 0; i < Position.values().length; i++) {
            System.out.println(" • " + i + " - " + Position.values()[i]);
        }
        String positionCode = sc.nextLine();
        Position position = Position.values()[Integer.parseInt(positionCode)];
        System.out.println("Введите номер статуса: ");
        for (int i = 0; i < Status.values().length; i++) {
            System.out.println(" • " + i + " - " + Status.values()[i]);
        }
        String statusCode = sc.nextLine();
        Status status = Status.values()[Integer.parseInt(statusCode)];
        System.out.println("Введите дату вструпления на должность в формате (ДД.ММ.ГГГГ): ");
        String startDateStr5 = sc.nextLine();
        DateFormat formatter25 = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate5;
        try {
            startDate5 = formatter25.parse(startDateStr5);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }
        Worker worker = new Worker(
                key1,
                name,
                LocalDateTime.now(),
                salary,
                startDate5,
                position,
                status,
                new Person(birthday5, color, country, new Location(x, y, z, locationName))
        );

         */
        Worker oldWorker = CollectionManager.getMap().get(key1);
        if (worker.compareTo(oldWorker) < 0){
            CollectionManager.removeKey(key1);
            CollectionManager.add(worker);
            System.out.println("Работяга создан и все таки заменил предыдущего работягу! (без негатива)");
        }else{
            System.out.println("Замена работяги не удалась, его зарплата оказалась маленькой(");
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("replace_if_greater - заменить значение по ключу, если новое значение больше старого");
    }
}
