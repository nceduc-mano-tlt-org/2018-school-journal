package ru.nceduc.journal.dao.connector;

import ru.nceduc.journal.dao.ConnectorDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorPostgresqlDao implements ConnectorDao {
    //private static ConnectorPostgresqlDao instance = new ConnectorPostgresqlDao();
    private static volatile ConnectorPostgresqlDao instance;
    private static Connection connection = null;
    private static final String URL = "jdbc:postgresql://thirdmadman.ddns.net:5432/thirdmadman_test";
    private static final String USER = "nctest";
    private static final String PASS = "5LLgK0jA2nzdKIGt";

    public static ConnectorPostgresqlDao getInstance() {
        ConnectorPostgresqlDao localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectorPostgresqlDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USER, PASS);
                        instance = localInstance = new ConnectorPostgresqlDao();
                    } catch (SQLException e) {
                        if (e instanceof SQLException) {
                            throw new RuntimeException("SQL exception - wasn't connected to postgres database.");
                        } else {
                            System.out.println("Connection Failed! Check output console for code exceptions.");
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
        return localInstance;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}