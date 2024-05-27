package lab_6.server;

import lab_6.common.Classes.Worker;

import java.io.Serializable;

public class ServerRequest implements Serializable {
    private final static long serialVersionUID = 22335L;
    private String commandName;
    private Worker worker;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String toString() {
        return ("Worker: " + worker + ", command: " + commandName);
    }
}
