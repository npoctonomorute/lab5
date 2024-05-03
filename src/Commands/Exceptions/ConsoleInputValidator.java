package Commands.Exceptions;

import App.AppContainer;

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
}

