package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.dao.Connector;
import ru.nceduc.journal.dao.TeacherDao_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl_JDBC implements TeacherDao_JDBC {

    @Override
    public boolean insertTeacher(Teacher teacher) {
        Connection connection = Connector.getConnection();
        String sql = "INSERT INTO teacher VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, teacher.getId());
            ps.setString(2, teacher.getProject().getId());
            ps.setString(3, teacher.getFirstName());
            ps.setString(4, teacher.getLastName());

            int eu = ps.executeUpdate();
            if (eu == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Teacher getTeacher(String teacherId) {
        Connection connection = Connector.getConnection();
        String sql = "SELECT * FROM teacher where teacher_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, teacherId);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(ps.toString());
            if (rs.next()) {
                return getTeacherFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Teacher getTeacherFromResultSet(ResultSet rs) throws SQLException{
        String id = rs.getString("teacher_id");
        String projectId = rs.getString("project_id");
        Project project = new Project(projectId);
        String firstName = rs.getString("firstname");
        String lastName = rs.getString("lastname");

        return new Teacher(id, project, firstName, lastName);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        Connection connection = Connector.getConnection();
        String sql = "UPDATE teacher SET project_id=?, firstname=?, lastname=? where teacher_id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, teacher.getProject().getId());
            ps.setString(2, teacher.getFirstName());
            ps.setString(3, teacher.getLastName());
            ps.setString(4, teacher.getId());

            int eu = ps.executeUpdate();
            if (eu == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(String teacherId) {
        Connection connection = Connector.getConnection();
        String sql = "DELETE FROM teacher WHERE teacher_id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, teacherId);

            int eu = ps.executeUpdate();
            if (eu == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Connection connection = Connector.getConnection();
        String sql = "SELECT * FROM teacher";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Teacher> teachers = new ArrayList<>();
            while (rs.next()) {
                Teacher teacher = getTeacherFromResultSet(rs);
                teachers.add(teacher);
            }
            return teachers;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
