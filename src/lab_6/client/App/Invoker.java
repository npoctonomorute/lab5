package lab_6.client.App;

import lab_6.client.Commands.*;

import java.util.HashMap;

public class Invoker {
    HashMap<String, Command> commands = new HashMap<>();

    public Invoker() {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("insert", new Insert());
        commands.put("update", new Update());
        commands.put("remove_key", new RemoveKey());
        commands.put("clear", new Clear());
        commands.put("exit", new Exit());
        commands.put("remove_greater", new RemoveGreater());
        commands.put("remove_lower", new RemoveLower());
        commands.put("remove_all_by_position", new RemoveAllByPosition());
        commands.put("filter_by_person", new FilterByPerson());
        commands.put("show", new Show());
        commands.put("execute_script", new ExecuteScript());
    }

    public void invoke(String req) {
        String[] parts = req.split(" ", 2);
        String commandName = parts[0];
        String arg = null;
        if (parts.length > 1) {
            arg = parts[1].trim();
        }
        if (commands.containsKey(commandName)) {
            Command com = commands.get(commandName);
            com.execute(arg);
        } else {
            System.out.println("Сори, нет такой команды.");
        }
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }
}