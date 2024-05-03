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

    public static String getIntInput() throws IntInputException {
        Scanner sc = AppContainer.getSc();
        String inputString = null;
        inputString = sc.nextLine().trim().toLowerCase();
        while (true) {
            try {
                int num = Integer.parseInt(inputString);
                return inputString;
            } catch (NumberFormatException e) {
                System.out.println("Введен не double, попробуйте снова: ");
                inputString = sc.nextLine();
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

