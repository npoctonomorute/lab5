package Commands;

import java.util.HashMap;

public class Invoker {
    HashMap<String, Command> commands = new HashMap<>();
    commands.put("help", new Help());

}
