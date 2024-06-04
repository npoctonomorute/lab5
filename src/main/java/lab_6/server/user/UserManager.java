package lab_6.server.user;

import java.sql.Connection;

public class UserManager {
    private final Connection connection;

    public UserManager(Connection connection) {
        this.connection = connection;
    }
}
