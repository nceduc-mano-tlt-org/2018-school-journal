package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.ConnectorDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorOracle implements ConnectorDao {
    private static ConnectorOracle singleton = null;
    private Connection connection = null;
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@sql.edu-netcracker.com:1251:xe";
    private static final String USER = "TLT_18";
    private static final String PASS = "TLT_18";

    private ConnectorOracle(Connection connection) {
        this.connection = connection;
    }

    public static ConnectorOracle getSingleton() {
        if (singleton == null) {
            try {
                Class.forName(DRIVER);
                Connection receivedConnection = DriverManager.getConnection(URL, USER, PASS);
                singleton = new ConnectorOracle(receivedConnection);
            } catch (ClassNotFoundException | SQLException e) {
                if (e instanceof ClassNotFoundException) {
                    throw new RuntimeException("JDBC Driver not found...");
                } else if (e instanceof SQLException) {
                    throw new RuntimeException("No connection to oracle database...");
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

