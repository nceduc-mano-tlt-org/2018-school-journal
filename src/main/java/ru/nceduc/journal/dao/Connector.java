package ru.nceduc.journal.dao;

import java.sql.Connection;

public interface Connector {
    Connection getConnection(String url, String username, String password);
}