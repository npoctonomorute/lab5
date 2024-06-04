package lab_6.server.app;

import lab_6.server.collection.PostgresCollectionManager;
import lab_6.server.user.UserManager;

import java.sql.Connection;

public class ServerAppContainer {
    private static Connection connection;

    private static PostgresCollectionManager collectionManager;

    private static UserManager userManager;

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ServerAppContainer.connection = connection;
    }

    public static PostgresCollectionManager getCollectionManager() {
        return collectionManager;
    }

    public static void setCollectionManager(PostgresCollectionManager collectionManager) {
        ServerAppContainer.collectionManager = collectionManager;
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static void setUserManager(UserManager userManager) {
        ServerAppContainer.userManager = userManager;
    }
}
