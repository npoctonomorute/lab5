package Commands;

import java.util.HashMap;
import java.util.Scanner;

public class Invoker {
    HashMap<String, Command> commands = new HashMap<>();
    public Invoker(){
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("insert", new Insert());
        commands.put("update", new Update());
        commands.put("remove_key", new RemoveKey());
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("exit", new Exit());
        commands.put("remove_greater", new RemoveGreater());
        commands.put("remove_lower", new RemoveLower());
        commands.put("replace_if_greater", new ReplaceIfGreater());
        commands.put("remove_all_by_position", new RemoveAllByPosition());
        commands.put("filter_by_person", new FilterByPerson());
        commands.put("filter_contains_name", new FilterContainsName());
    }

    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
        String line = sc.next();
        String[] tokens = line.split(" ");
        Command command = commands.get(tokens[0]);
        command.execute();
    }
}