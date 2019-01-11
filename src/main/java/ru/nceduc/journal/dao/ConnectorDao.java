package ru.nceduc.journal.dao;

import java.sql.Connection;

public interface ConnectorDao {
    Connection getConnection();
}