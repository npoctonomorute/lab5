package lab_6.client.App;

import lab_6.common.Classes.User;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ClientAppContainer {
    private static Scanner sc; // гооол

    private static final Deque<File> scriptsStack = new ArrayDeque<>();

    private static User user;

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        ClientAppContainer.sc = sc;
    }

    public static Deque<File> getScriptsStack() {
        return scriptsStack;
    }


    public static File getCurrentScript() {
        if (scriptsStack.isEmpty()) {
            return null;
        }
        return scriptsStack.getLast();
    }

    public static boolean isInteractiveMode() {
        return !scriptsStack.isEmpty();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        ClientAppContainer.user = user;
    }

    public static boolean isLoggedIn() {
        return user != null;
    }
}
