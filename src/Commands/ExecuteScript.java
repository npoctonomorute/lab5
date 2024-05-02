package Commands;

import App.AppContainer;
import App.Invoker;

import java.io.*;
import java.util.Scanner;

public class ExecuteScript implements Command {

    @Override
    public void execute(String arg) {
        File file = new File(arg);
        if (!(file.exists() && file.canRead())) {
            System.out.println("Файл не найден или нет доступа к нему, соре.");
            return;
        }
        if (AppContainer.getScriptsStack().contains(file)) {
            System.out.println("Круг замкнулся, соре.");
            return;
        }
        Scanner oldsc = AppContainer.getSc();

        AppContainer.getScriptsStack().add(file);
        Invoker invoker = new Invoker();

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        AppContainer.setSc(sc);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
            invoker.invoke(line);
        }
        AppContainer.setSc(oldsc);
        AppContainer.getScriptsStack().removeLast();
    }

    @Override
    public String description() {
        return "execute_script - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
