package ru.nceduc.journal.dao.connector;

import ru.nceduc.journal.dao.ConnectorDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorEmbededDao implements ConnectorDao {
    private static volatile ConnectorEmbededDao instance;
    private static Connection connection = null;
    private static final String URL = "jdbc:h2:mem:database";

    public static ConnectorEmbededDao getInstance() {
        ConnectorEmbededDao localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectorEmbededDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    try {
                        connection = DriverManager.getConnection(URL);
                        instance = localInstance = new ConnectorEmbededDao();
                    } catch (SQLException e) {
                        if (e instanceof SQLException) {
                            throw new RuntimeException("SQL exception - wasn't connected to local database.");
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
