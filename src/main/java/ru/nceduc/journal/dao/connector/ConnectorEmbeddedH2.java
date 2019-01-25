package ru.nceduc.journal.dao.connector;

import ru.nceduc.journal.dao.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorEmbeddedH2 implements Connector {
    private static ConnectorEmbeddedH2 instance = null;
    private Connection connection = null;
    private static final String URL = "jdbc:h2:mem:database";

    private ConnectorEmbeddedH2(Connection connection) {
        this.connection = connection;
    }

    public static ConnectorEmbeddedH2 getInstance() {
        if (instance == null) try {
            Connection receivedConnection = DriverManager.getConnection(URL);
            instance = new ConnectorEmbeddedH2(receivedConnection);
        } catch (SQLException e) {
            throw new RuntimeException("No connection to h2 local database...");
        }
        return instance;
    }
    @Override
    public Connection getConnection() {
        return connection;
    }
}