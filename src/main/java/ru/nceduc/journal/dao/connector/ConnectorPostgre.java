package ru.nceduc.journal.dao.connector;

import lombok.Getter;
import lombok.Setter;
import ru.nceduc.journal.dao.Connector;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectorPostgre implements Connector {
    private Connection connection;
    private static ConnectorPostgre instance;
    @Setter
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    @Setter
    private static String username = "user";
    @Setter
    private static String password = "user1";

    @Override
    public Connection getConnection() {
        return connection;
    }

    private ConnectorPostgre() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection failed: " + ex.getMessage());
        }
    }

    public static ConnectorPostgre getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectorPostgre();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectorPostgre();
        }
        return instance;
    }
}

