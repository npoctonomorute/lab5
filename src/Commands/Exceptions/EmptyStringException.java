package Commands.Exceptions;

public class EmptyStringException extends Exception{
    public EmptyStringException() {
        super("Строка пуста или null.");
    }

}
