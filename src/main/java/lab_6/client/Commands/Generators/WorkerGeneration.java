package lab_6.client.Commands.Generators;

import lab_6.client.App.ClientAppContainer;
import lab_6.client.Commands.Exceptions.ConsoleInputValidator;
import lab_6.client.Commands.Exceptions.DoubleInputException;
import lab_6.client.Commands.Exceptions.IntInputException;
import lab_6.common.Classes.*;
import lab_6.common.Classes.dto.WorkerDTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WorkerGeneration {
    public WorkerDTO execute() {
        Scanner sc = ClientAppContainer.getSc();

        System.out.println("Введите имя: ");
        String name = null;
//        try {
        name = ConsoleInputValidator.getNonEmptyInput();
//        } catch (EmptyStringException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Введите имя: ");
//        }

        System.out.println("Введите дату рождения в формате (ДД.ММ.ГГГГ): ");
        String birthdayStr1 = sc.nextLine().trim().toLowerCase();
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
        String colorCode = null;
        try {
            colorCode = ConsoleInputValidator.getEnumException(Color.values().length);
        } catch (IntInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите номер цвета волос: ");
        }
        Color color = Color.values()[Integer.parseInt(colorCode)];


        System.out.println("Введите номер национальности: ");
        for (int i = 0; i < Country.values().length; i++) {
            System.out.println(" • " + i + " - " + Country.values()[i]);
        }
        String countryCode = null;
        try {
            countryCode = ConsoleInputValidator.getEnumException(Country.values().length);
        } catch (IntInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите номер национальности: ");
        }
        Country country = Country.values()[Integer.parseInt(countryCode)];


        System.out.println("Введите координаты и имя локации: ");
        Double x = (double) 0;
        Double y = (double) 0;
        Double z = (double) 0;
        String locationName = null;
        System.out.println("Введите координату по x: ");
        try {
            x = Double.parseDouble(ConsoleInputValidator.getDoubleInput());
        } catch (DoubleInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите координату по x:");
        }

        System.out.println("Введите координату по y: ");
        try {
            y = Double.parseDouble(ConsoleInputValidator.getDoubleInput());
        } catch (DoubleInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите координату по y:");
        }

        System.out.println("Введите координату по z: ");
        try {
            z = Double.parseDouble(ConsoleInputValidator.getDoubleInput());
        } catch (DoubleInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите координату по z:");
        }

        System.out.println("Введите название локации: ");
//        try {
        locationName = ConsoleInputValidator.getNonEmptyInput();
//        } catch (EmptyStringException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Введите название локации: ");
//        }
        System.out.println("Введите размер зарплаты: ");
        double salary = 0;
        try {
            salary = Double.parseDouble(ConsoleInputValidator.getSalaryInput());
        } catch (DoubleInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите размер зарплаты: ");
        }


        System.out.println("Введите номер профессии: ");
        for (int i = 0; i < Position.values().length; i++) {
            System.out.println(" • " + i + " - " + Position.values()[i]);
        }
        String positionCode = null;
        try {
            positionCode = ConsoleInputValidator.getEnumException(Position.values().length - 1);
        } catch (IntInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите номер профессии: ");
        }
        Position position = Position.values()[Integer.parseInt(positionCode)];


        System.out.println("Введите номер статуса: ");
        for (int i = 0; i < Status.values().length; i++) {
            System.out.println(" • " + i + " - " + Status.values()[i]);
        }
        String statusCode = null;
        try {
            statusCode = ConsoleInputValidator.getEnumException(Status.values().length - 1);
        } catch (IntInputException e) {
            System.out.println(e.getMessage());
            System.out.println("Введите номер статуса: ");
        }
        Status status = Status.values()[Integer.parseInt(statusCode)];


        System.out.println("Введите дату вступления на должность в формате (ДД.ММ.ГГГГ): ");
        String startDateStr1 = sc.nextLine().trim().toLowerCase();
        DateFormat formatter12 = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate1;
        try {
            startDate1 = formatter12.parse(startDateStr1);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат ввода даты.");
        }
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setName(name);
        workerDTO.setSalary(salary);
        workerDTO.setStartDate(startDate1);
        workerDTO.setPosition(position);
        workerDTO.setStatus(status);
        workerDTO.setPerson(new Person(birthday1, color, country, new Location(x, y, z, locationName)));
        return workerDTO;
    }
}
