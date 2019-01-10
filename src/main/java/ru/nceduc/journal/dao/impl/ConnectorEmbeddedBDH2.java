package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.ConnectorDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorEmbeddedBDH2 implements ConnectorDao {
    private static ConnectorEmbeddedBDH2 singleton = null;
    private Connection connection = null;
    private static final String URL = "jdbc:h2:mem:database";

    private ConnectorEmbeddedBDH2(Connection connection) {
        this.connection = connection;
    }

    public static ConnectorEmbeddedBDH2 getSingleton() {
        if (singleton == null) try {
            Connection receivedConnection = DriverManager.getConnection(URL);
            singleton = new ConnectorEmbeddedBDH2(receivedConnection);
        } catch (SQLException e) {
                throw new RuntimeException("No connection to h2 local database...");
        }
        return singleton;
    }
    @Override
    public Connection getConnection() {
        return connection;
    }
}
