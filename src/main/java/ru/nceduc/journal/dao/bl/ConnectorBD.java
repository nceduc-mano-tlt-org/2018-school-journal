package ru.nceduc.journal.dao.bl;

import ru.nceduc.journal.dao.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorBD implements Connector {
    private static ConnectorBD connectionBD = null;
    private  Connection connection = null;
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@sql.edu-netcracker.com:1251:xe";
    private static final String DB_USERNAME = "TLT_30";
    private static final String DB_PASSWORD = "TLT_30";

    private ConnectorBD(Connection connection){
        this.connection = connection;
    }

    public static ConnectorBD getConnetctionBD() {
        if (connectionBD ==null) {

            try {
                Class.forName(DB_DRIVER);
                try {
                    Connection receivedConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    connectionBD = new ConnectorBD(receivedConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Connection OK");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Connection ERROR");
            }
        }
        return connectionBD;
    }
    @Override
    public Connection getConnection(){
        return connection;
    }

}
