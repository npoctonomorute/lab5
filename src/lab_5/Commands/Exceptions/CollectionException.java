package lab_5.Commands.Exceptions;

public class CollectionException extends Exception {
    public CollectionException() {
        super("Файл, содержащий коллекцию, был изменен некорректно.");
    }
}
