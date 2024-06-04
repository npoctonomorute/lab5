package lab_6.client.Commands;

import lab_6.client.App.ClientAppContainer;
import lab_6.client.App.Invoker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScript implements Command {

    @Override
    public void execute(String arg) {
        File file = new File(arg);
        if (!(file.exists() && file.canRead())) {
            System.out.println("Файл не найден или нет доступа к нему, соре.");
            return;
        }
        if (ClientAppContainer.getScriptsStack().contains(file)) {
            System.out.println("Круг замкнулся, соре.");
            return;
        }
        Scanner oldsc = ClientAppContainer.getSc();

        ClientAppContainer.getScriptsStack().add(file);
        Invoker invoker = new Invoker();

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ClientAppContainer.setSc(sc);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
            invoker.invoke(line);
        }
        ClientAppContainer.setSc(oldsc);
        ClientAppContainer.getScriptsStack().removeLast();
    }

    @Override
    public String description() {
        return "execute_script - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
