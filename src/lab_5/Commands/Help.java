package lab_5.Commands;

import lab_5.App.Invoker;

import java.util.HashMap;

public class Help implements Command{
    /**
     *
     */
    @Override
    public void execute(String arg) {
        Invoker invoker = new Invoker();
        HashMap<String, Command> commands = invoker.getCommands();
        for (Command c : commands.values()){
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
}