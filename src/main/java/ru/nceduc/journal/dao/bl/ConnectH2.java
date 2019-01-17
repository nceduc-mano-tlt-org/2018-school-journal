package ru.nceduc.journal.dao.bl;

import ru.nceduc.journal.dao.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectH2 {
    private static ConnectH2 connectH2 = null;
    private Connection connection = null;
    private static final String URL = "jdbc:h2:mem:database";

    private ConnectH2(Connection connection) {
        this.connection = connection;
    }

    public static ConnectH2 getConnectH2() {
        if (connectH2 == null) try {
            Connection receivedConnection = DriverManager.getConnection(URL);
            connectH2 = new ConnectH2(receivedConnection);
        } catch (SQLException e) {
            throw new RuntimeException("No connection");
        }
        return connectH2;
    }
    public Connection getConnection() {
        return connection;
    }
}
