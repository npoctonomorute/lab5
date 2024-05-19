package lab_6.Commands;

public interface Command {
    void execute(String arg);

    String description();
}
