import App.AppContainer;
import App.Invoker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppContainer.setSc(sc);
        Invoker invoker = new Invoker();
        while (sc.hasNextLine()){
            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
            invoker.invoke(line);
        }
    }
}