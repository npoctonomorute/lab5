package lab_6.Commands.Exceptions;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Строка пуста или null.");
    }

}
