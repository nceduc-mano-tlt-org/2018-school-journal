package ru.nceduc.journal.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Connector {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "user";
    private static final String PASS = "user1";

    public static Connection getConnection() {
        Connection connection;
        try {
            return connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}

