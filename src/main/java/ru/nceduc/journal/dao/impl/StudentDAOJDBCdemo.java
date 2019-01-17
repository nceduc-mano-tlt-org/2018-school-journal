package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class StudentDAOJDBCdemo implements JournalDao<Student> {

    Connection connection = null;

    public StudentDAOJDBCdemo(Connection connection){
        this.connection = connection;
    }

    private Student getReformedResultSetInSection(ResultSet resultSet) throws SQLException {
        String idStudent = resultSet.getString("student_id");
        Project project = new Project(resultSet.getString("student_project_id"));
        String firstNameStudent = resultSet.getString("student_first_name");
        String lastNameStudent = resultSet.getString("student_last_name");
        return new Student(idStudent,project,firstNameStudent,lastNameStudent);
    }

    @Override
    public Student find(String id) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
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
    public Student add(Student entity) {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";
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
    public Student remove(String id) {
        Student student = find(id);
        String sql = "DELETE FROM students WHERE student_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            if (statement.executeUpdate() == 1) {
                statement.close();
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }
}
