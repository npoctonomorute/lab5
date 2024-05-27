package lab_6.client.Commands.Exceptions;

public class EnumException extends Exception {
    public EnumException(int i) {
        super("Нужно ввести одно из предложенных чисел, а не какое попало, так вот.");
    }
}
