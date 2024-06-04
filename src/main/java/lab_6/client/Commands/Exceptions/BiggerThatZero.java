package lab_6.client.Commands.Exceptions;

public class BiggerThatZero extends Exception {
    public BiggerThatZero() {
        super("Число меньше нуля, соре.");
    }

}
