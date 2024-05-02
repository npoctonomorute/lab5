package Commands.Exceptions;

import App.AppContainer;

import java.util.Scanner;

public class ConsoleInputValidator {
    public static String getNonEmptyInput() throws EmptyStringException {
        Scanner scanner = AppContainer.getSc();
        String inputString = null;
        do {
            inputString = scanner.nextLine();
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
}

