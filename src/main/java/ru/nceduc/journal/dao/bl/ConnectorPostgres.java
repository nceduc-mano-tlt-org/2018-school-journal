package ru.nceduc.journal.dao.bl;

import ru.nceduc.journal.dao.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorPostgres implements Connector {
    private static ConnectorPostgres connectorPostgres = null;
    private Connection connection = null;
    private static final String URL = "jdbc:postgresql://thirdmadman.ddns.net:5432/school-journal";
    private static final String USER = "nctest";
    private static final String PASS = "5LLgK0jA2nzdKIGt";

    private ConnectorPostgres(Connection connection) {
        this.connection = connection;
    }

    public static ConnectorPostgres getConnectorPostgres() {
        if (connectorPostgres == null) {
            try {
                Connection receivedConnection = DriverManager.getConnection(URL, USER, PASS);
                connectorPostgres = new ConnectorPostgres(receivedConnection);
            } catch (SQLException e) {
                if (e instanceof SQLException) {
                    throw new RuntimeException("No connection to postgre database...");
                }
            }
        }
        return connectorPostgres;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public Connection getConnectionPost() {
        return connection;
    }
}
