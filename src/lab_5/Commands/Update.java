package lab_5.Commands;

import lab_5.App.AppContainer;
import lab_5.App.CollectionManager;
import lab_5.Commands.Generators.WorkerGeneration;
import lab_5.Data.*;

import java.util.Scanner;

public class Update implements Command {

    Scanner sc = AppContainer.getSc();
    @Override
    public void execute(String arg) {
        System.out.println("Начинается замена работяги по ключу!!!");
        long key = Long.parseLong(arg);
        WorkerGeneration workerGeneration = new WorkerGeneration();
        Worker worker = workerGeneration.execute();
        /*
        System.out.println("Введите имя: ");
        String name = sc.nextLine();
        System.out.println("Введите дату рождения в формате (ДД.ММ.ГГГГ): ");
        String birthdayStr = sc.nextLine();
        DateFormat formatter6 = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday6;
        try {
            birthday6 = formatter6.parse(birthdayStr);
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
        String startDateStr6 = sc.nextLine();
        DateFormat formatter26 = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate6;
        try {
            startDate6 = formatter26.parse(startDateStr6);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }
        Worker worker = new Worker(
                key,
                name,
                LocalDateTime.now(),
                salary,
                startDate6,
                position,
                status,
                new Person(birthday6, color, country, new Location(x, y, z, locationName))
        );

         */
        CollectionManager.removeKey(key);
        CollectionManager.add(worker);
        System.out.println("Работяга создан и заменил предыдущего работягу! (без негатива)");
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("update - обновить значение элемента коллекции, id которого равен заданному");
    }
}
