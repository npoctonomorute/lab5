package lab_6.client.Commands.Exceptions;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Строка пуста или null.");
    }

}
