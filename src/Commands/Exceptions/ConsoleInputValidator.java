package Commands.Exceptions;

import java.util.Scanner;

public class ConsoleInputValidator {
    public static String getNonEmptyInput() throws EmptyStringException {
        Scanner scanner = new Scanner(System.in);
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

