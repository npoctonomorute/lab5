package lab_5.Commands;

public class Exit implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        System.exit(0);
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return "exit - завершить программу (без сохранения в файл)";
    }
}
