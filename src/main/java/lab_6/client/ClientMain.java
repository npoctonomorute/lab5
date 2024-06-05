package lab_6.client;

import lab_6.client.App.ClientAppContainer;
import lab_6.client.App.Invoker;
import lab_6.client.App.ServerUnavailableException;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("атака амогусов началась ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ ඞ");
        Scanner sc = new Scanner(System.in);
        ClientAppContainer.setSc(sc);
        Invoker invoker = new Invoker();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim().toLowerCase(); //обрезает пробелы + нижний регистр
            try {
                invoker.invoke(line);
            } catch (ServerUnavailableException e) {
                System.out.println("Сорри, сервер недоступен. Попробуй позже");
            }
        }
    }
}
