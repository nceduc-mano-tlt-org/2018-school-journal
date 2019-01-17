package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Student;
import ru.nceduc.journal.entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class TeacherDAOJDBCdemo implements JournalDao<Teacher> {

    Connection connection = null;

    public TeacherDAOJDBCdemo(Connection connection){
        this.connection = connection;
    }

    private Teacher getReformedResultSetInSection(ResultSet resultSet) throws SQLException {
        String idTeacher = resultSet.getString("teacher_id");
        Project project = new Project(resultSet.getString("teacher_project_id"));
        String firstNameTeacher = resultSet.getString("teacher_first_name");
        String lastNameTeacher = resultSet.getString("teacher_last_name");
        return new Teacher(idTeacher,project,firstNameTeacher,lastNameTeacher);
    }

    @Override
    public Teacher find(String id) {
        String sql = "SELECT * FROM teachers WHERE teacher_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getReformedResultSetInSection(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher add(Teacher entity) {
        String sql = "INSERT INTO teachers VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getId());
            statement.setString(2, entity.getProject().getId());
            statement.setString(3, entity.getFirstName());
            statement.setString(4, entity.getLastName());

            if (statement.executeUpdate() == 1) {
                statement.close();
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher remove(String id) {
        Teacher teacher = find(id);
        String sql = "DELETE FROM teachers WHERE teacher_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            if (statement.executeUpdate() == 1) {
                statement.close();
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher update(Teacher entity) {
        return null;
    }
}
