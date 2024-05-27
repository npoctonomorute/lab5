package lab_6.client.Commands;

import lab_6.client.App.AppContainer;
import lab_6.server.CollectionManager;
import lab_6.client.Commands.Generators.WorkerGeneration;
import lab_6.common.Classes.Worker;

import java.util.Scanner;

public class Insert implements Command {
    /**
     *
     */
    Scanner sc = AppContainer.getSc();

    @Override
    public void execute(String arg) {
        System.out.println("Начинается создание работяги!!!");

        /*System.out.println("Введите имя: ");
        String name = sc.nextLine();

        System.out.println("Введите дату рождения в формате (ДД.ММ.ГГГГ): ");
        String birthdayStr1 = sc.nextLine();
        DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday1;
        try {
            birthday1 = formatter1.parse(birthdayStr1);
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
        String startDateStr1 = sc.nextLine();
        DateFormat formatter12 = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate1;
        try {
            startDate1 = formatter12.parse(startDateStr1);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }
        Worker worker = new Worker(
                CollectionManager.generateId(),
                name,
                LocalDateTime.now(),
                salary,
                startDate1,
                position,
                status,
                new Person(birthday1, color, country, new Location(x, y, z, locationName))
        );

         */
        WorkerGeneration workerGeneration = new WorkerGeneration();
        Worker worker = workerGeneration.execute();
        CollectionManager.add(worker);
        System.out.println("Работяга создан и добавлен!");
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return "insert - добавить новый элемент с заданным ключом";
    }
}
