package lab_6.Commands;

import lab_6.App.AppContainer;
import lab_6.App.CollectionManager;
import lab_6.Commands.Generators.WorkerGeneration;
import lab_6.Data.Worker;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveLower implements Command {
    /**
     *
     */
    Scanner sc = AppContainer.getSc();

    @Override
    public void execute(String arg) {
        System.out.println("Начинается генерации работяги для сравнения!!!");
        WorkerGeneration workerGeneration = new WorkerGeneration();
        Worker worker = workerGeneration.execute();
        /*System.out.println("Введите имя: ");
        String name = sc.nextLine();
        System.out.println("Введите дату рождения в формате (ДД.ММ.ГГГГ): ");
        String birthdayStr = sc.nextLine();
        DateFormat formatter4 = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday4;
        try {
            birthday4 = formatter4.parse(birthdayStr);
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
        String startDateStr4 = sc.nextLine();
        DateFormat formatter24 = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate4;
        try {
            startDate4 = formatter24.parse(startDateStr4);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }
        Worker worker = new Worker(
                CollectionManager.generateId(),
                name,
                LocalDateTime.now(),
                salary,
                startDate4,
                position,
                status,
                new Person(birthday4, color, country, new Location(x, y, z, locationName))
        );
         */
        HashMap<Long, Worker> coll = CollectionManager.getMap();
        for (Worker newWorker : coll.values()) {
            if (worker.compareTo(newWorker) > 0) {
                CollectionManager.removeKey(newWorker.getId());
                System.out.println("Работяга с ID = " + newWorker.getId() + " устранен, у него слишком маленькая зарплата!");
            } else {
                System.out.println("Работяга с ID = " + newWorker.getId() + " оставлен, его зарплата достаточно велика!");
            }
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("remove_lower - удалить из коллекции все элементы, меньшие, чем заданный");
    }
}
