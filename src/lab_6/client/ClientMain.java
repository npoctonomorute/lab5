package lab_6.client;

import lab_6.client.App.AppContainer;
import lab_6.client.App.Invoker;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("привет от амогусов ඞඞඞඞඞඞඞඞඞඞඞඞඞ");
        Scanner sc = new Scanner(System.in);
        AppContainer.setSc(sc);
        Invoker invoker = new Invoker();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
            invoker.invoke(line);
        }
    }
}
