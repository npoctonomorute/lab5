package lab_6.client.Commands;

import lab_6.client.App.Invoker;

import java.util.HashMap;

public class Help implements Command {
    /**
     *
     */
    @Override
    public void execute(String arg) {
        Invoker invoker = new Invoker();
        HashMap<String, Command> commands = invoker.getCommands();
        for (Command c : commands.values()) {
            System.out.println(c.description());
        }
    }

    /**
     * @return
     */
    @Override
    public String description() {
        return ("help — помощь, вывод справки по доступным командам и формату их использования");
    }

    public boolean needToAuthorize() {
        return false;
    }
}
