package lab_6.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMigration {
    public static final String DB_URL = "jdbc:postgresql://pg:5432/studs";
    public static final String DB_USER = "s408180";
    public static final String DB_PASSWORD = "Ht57z7olN3N7AAi4";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            connection.createStatement().execute("""
                    CREATE TABLE IF NOT EXISTS workers
                    (
                        id            bigserial,
                        name          varchar(255)     NOT NULL,
                        creation_date date             NOT NULL DEFAULT now(),
                        salary        double precision NOT NULL,
                        start_date    date             NOT NULL,
                        "position"    smallint,
                        status        smallint         NOT NULL,
                        p_birthday    date,
                        p_hair_color  smallint,
                        p_nationality smallint,
                        p_loc_x       double precision,
                        p_loc_y       double precision,
                        p_loc_z       double precision,
                        p_loc_name    varchar(255),
                        owner_login   varchar(255)     NOT NULL,
                        CONSTRAINT workers_pkey PRIMARY KEY (id)
                    )
                    """);
            connection.createStatement().execute("""
                    CREATE TABLE IF NOT EXISTS users
                    (
                        id       bigserial,
                        login    varchar(255) NOT NULL,
                        password varchar(255) NOT NULL,
                        CONSTRAINT users_pkey PRIMARY KEY (id),
                        CONSTRAINT login_unique UNIQUE (login)
                    )
                    """);
        }
    }
}
