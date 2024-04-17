package Commands;

import Data.Collection;

public class Help implements Command{
    /**
     *
     */
    @Override
    public void execute() {
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
