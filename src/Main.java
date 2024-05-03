import App.AppContainer;
import App.CollectionManager;
import App.Invoker;
import JSON.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //ToDo обработать, если аргумента нет СДЕЛАНО
        if (args.length == 0) {
            System.out.println("Не указан файл с коллекцией");
            System.exit(0);
        }
        CollectionManager collection = null;
        try {
            JsonParser parser = new JsonParser(args[0]);
            collection = parser.parse();
        } catch (NullPointerException e) {
            System.out.println("Этот файл пустой, не могу работать с ним.");
            System.exit(0);
        }
        File file = new File(Arrays.toString(args));
        if (!file.exists()) {
            System.out.println("Файла не существует.");
            System.exit(0);
        }
        JsonParser parser = new JsonParser(args[0]);
        //ToDo не работает с пустым файлом СДЕЛАНО
        //ToDo не работает с несуществующим файлом (не обрабатывает такую ситуацию) ПОЛУСДЕЛАНО
        //ToDo нет валидации данных в файле

        System.out.println(collection.getMap());
        Scanner sc = new Scanner(System.in);
        AppContainer.setSc(sc);
        Invoker invoker = new Invoker();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
            invoker.invoke(line);
        }
    }
}
