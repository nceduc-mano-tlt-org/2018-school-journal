package ru.nceduc.journal.dao;

import ru.nceduc.journal.entity.Group;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao_JDBC {

    void add(Group group) throws SQLException;

    List<Group> getAll();

    Group getById(int id);

    void update(Group group);

    void remove(Group group) throws SQLException;
}
