package lab_6.client.Commands;

public interface Command {
    void execute(String arg);

    String description();

    default boolean needToAuthorize() {
        return true;
    }
}
