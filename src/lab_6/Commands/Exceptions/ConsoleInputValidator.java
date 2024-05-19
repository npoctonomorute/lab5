package lab_6.Commands.Exceptions;

import lab_6.App.AppContainer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleInputValidator {
    /**
     * @return
     * @throws EmptyStringException
     */
    public static String getNonEmptyInput() throws EmptyStringException {
        Scanner sc = AppContainer.getSc();
        String inputString = null;
        do {
            inputString = sc.nextLine().trim().toLowerCase();
            if (inputString == null || inputString.isEmpty()) {
                try {
                    throw new EmptyStringException();
                } catch (EmptyStringException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Введите заново:");
                }
            }
        } while (inputString == null || inputString.isEmpty());
        return inputString;
    }

    public static String getEnumException(int i) throws IntInputException {
        Scanner sc = AppContainer.getSc();
        String inputString = null;
        inputString = sc.nextLine().trim().toLowerCase();
        while (true) {
            try {
                int num = Integer.parseInt(inputString);
                if ((num > i) || (num < 0)) {
                    throw new EnumException(i);
                }
                return inputString;
            } catch (NumberFormatException e) {
                System.out.println("Введен не int, попробуйте снова: ");
                inputString = sc.nextLine().trim().toLowerCase();
            } catch (EnumException e) {
                System.out.println("Введено число не из списка, исправляйся: ");
                inputString = sc.nextLine().trim().toLowerCase();
            }
        }
    }

    public static String getSalaryInput() throws DoubleInputException {
        Scanner sc = AppContainer.getSc();
        String inputString = null;
        inputString = sc.nextLine().trim().toLowerCase();
        while (true) {
            try {
                double num = Double.parseDouble(inputString);
                if (num < 0) {
                    throw new BiggerThatZero();
                }
                return inputString;
            } catch (NumberFormatException e) {
                System.out.println("Введен не double, попробуйте снова: ");
                inputString = sc.nextLine().trim().toLowerCase();
            } catch (BiggerThatZero e) {
                System.out.println("Введено отрицательное число, давай еще раз: ");
                inputString = sc.nextLine().trim().toLowerCase();
            }
        }
    }

    public static String getDoubleInput() throws DoubleInputException {
        Scanner sc = AppContainer.getSc();
        String inputString = null;
        inputString = sc.nextLine().trim().toLowerCase();
        while (true) {
            try {
                double num = Double.parseDouble(inputString);
                return inputString;
            } catch (NumberFormatException e) {
                System.out.println("Введен не double, попробуйте снова: ");
                inputString = sc.nextLine();
            }
        }
    }

    public static String getDataInput() throws ParseException {
        Scanner sc = AppContainer.getSc();
        String inputString = null;
        inputString = sc.nextLine().trim().toLowerCase();
        while (true) {
            try {
                DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");
                Date birthday1 = formatter1.parse(inputString);
                return inputString;
            } catch (ParseException e) {
                System.out.println("Неверный формат ввода даты.");
            }
        }
    }
}
//    public static String getDoubleInput() throws DoubleInputException {
//        Scanner sc = AppContainer.getSc();
//        String inputString = null;
//        inputString = sc.nextLine().trim().toLowerCase();
//        while (true) {
//            try {
//                double num = Double.parseDouble(inputString);
//                return inputString;
//            } catch (NumberFormatException e) {
//                System.out.println("Введен не double, попробуйте снова: ");
//                inputString = sc.nextLine();
//            }
//        }
//    }

//System.out.println("Введите дату рождения в формате (ДД.ММ.ГГГГ): ");
//        String birthdayStr1 = sc.nextLine().trim().toLowerCase();
//        DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");
//        Date birthday1;
//        try {
//        Date birthday1 = formatter1.parse(birthdayStr1);
//        } catch (ParseException e) {
//        throw new RuntimeException("Неверный формат ввода даты.");
//        }

