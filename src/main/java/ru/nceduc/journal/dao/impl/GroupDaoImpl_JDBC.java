package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.Connector;
import ru.nceduc.journal.dao.GroupDao_JDBC;
import ru.nceduc.journal.dao.bl.Util;
import ru.nceduc.journal.entity.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl_JDBC extends Util implements GroupDao_JDBC {

    Connection connection = getConnection();

    @Override
    public void add(Group group) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO GROUP_JDBC (ID , GROUPNAME , SECTION , TEACHERS, STUDENTS ) VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, group.getId());
            preparedStatement.setString(2, group.getSection().getId());
            preparedStatement.setString(3, group.getGroupName());
            preparedStatement.setString(4, String.valueOf(group.getTeachers()));//Правильно?Описан изначально , как лист.
            preparedStatement.setString(5, String.valueOf(group.getStudents()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Group> getAll() {
        //List<Group> groups = new ArrayList<>();

        //String sql =;
        //Statement statement = null;
        return null;
    }

    @Override
    public Group getById(int id) {
        //PreparedStatement preparedStatement = null;
        //String sql =;
        //Group group = new Group();
        return null;

    }

    @Override
    public void update(Group group) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE GROUP_JDBC SET GROUPNAME=?, SECTION=?, TEACHERS=? , STUDENT=? where ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,group.getGroupName());
            preparedStatement.setString(2,group.getSection().getId());
            preparedStatement.setString(3, String.valueOf(group.getTeachers()));
            preparedStatement.setString(4, String.valueOf(group.getStudents()));
            preparedStatement.setString(5,group.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void remove(Group group) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM GROUP_JDBC WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, group.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}
