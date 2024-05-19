package lab_5.Commands.Exceptions;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Строка пуста или null.");
    }

}
