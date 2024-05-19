package lab_5.Commands.Exceptions;

public class BiggerThatZero extends Exception {
    public BiggerThatZero() {
        super("Число меньше нуля, соре.");
    }

}
