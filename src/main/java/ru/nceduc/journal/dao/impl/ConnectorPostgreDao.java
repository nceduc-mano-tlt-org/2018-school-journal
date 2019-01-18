package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.ConnectorDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorPostgreDao implements ConnectorDao {
    private static ConnectorPostgreDao singleton = null;
    private Connection connection = null;
    private static final String URL = "jdbc:postgresql://thirdmadman.ddns.net:5432/quikitConsoleManager";
    private static final String USER = "nctest";;
    private static final String PASS = "5LLgK0jA2nzdKIGt";

    private ConnectorPostgreDao(Connection connection) {
        this.connection = connection;
    }

    public static ConnectorPostgreDao getSingleton() {
        if (singleton == null) {
            try {
                Connection receivedConnection = DriverManager.getConnection(URL, USER, PASS);
                singleton = new ConnectorPostgreDao(receivedConnection);
            } catch (SQLException e) {
                if (e instanceof SQLException) {
                    throw new RuntimeException("No connection to postgre database...");
                }
            }
        }
        return singleton;
    }
    @Override
    public Connection getConnection() {
        return connection;
    }
}
