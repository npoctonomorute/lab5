package lab_6.client.App;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AppContainer {

    private static Scanner sc; // гооол

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        AppContainer.sc = sc;
    }

    private static final Deque<File> scriptsStack = new ArrayDeque<>();

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
}
