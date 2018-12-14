package ru.nceduc.journal.dao;

import ru.nceduc.journal.dao.bl.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static void main(String[] args) {
        Util util = new Util();
        util.getConnection();
    }
}
