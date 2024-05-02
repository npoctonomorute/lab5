import App.AppContainer;
import App.CollectionManager;
import App.Invoker;
import JSON.JsonParser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JsonParser parser = new JsonParser(args[0]);
        CollectionManager collection = parser.parse();
        System.out.println(collection.getMap());
        Scanner sc = new Scanner(System.in);
        AppContainer.setSc(sc);
        Invoker invoker = new Invoker();
        while (sc.hasNextLine()){
            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
            invoker.invoke(line);
        }
    }
}
