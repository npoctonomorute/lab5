package lab_5.Commands.Exceptions;

public class IntInputException extends Exception {
    public IntInputException() {
        super("Нужно ввести int.");
    }
}