package ru.nceduc.journal.dao.connector;

import ru.nceduc.journal.dao.Connector;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorPostgre implements Connector {
    @Override
    public Connection getConnection(String url, String username, String password) {
        Connection connection;
        try {
            return connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}