package lab_5.Commands.Exceptions;

public class DataException extends Exception {
    public DataException() {
        super("Неверный формат ввода даты.");
    }
}