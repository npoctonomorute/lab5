package lab_5.Commands;

public interface Command {
    void execute(String arg);
    String description();
}
