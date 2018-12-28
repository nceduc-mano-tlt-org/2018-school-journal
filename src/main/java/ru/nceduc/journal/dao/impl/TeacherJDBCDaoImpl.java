package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.dao.connector.ConnectorPostgre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class TeacherJDBCDaoImpl implements JournalDao<Teacher> {

    private Teacher getTeacherFromResultSet(ResultSet rs) throws SQLException{
        String id = rs.getString("teacher_id");
        String projectId = rs.getString("project_id");
        Project project = new Project(projectId);
        String firstName = rs.getString("firstname");
        String lastName = rs.getString("lastname");

        return new Teacher(id, project, firstName, lastName);
    }

    @Override
    public Teacher find(String id) {
        String sql = "SELECT * FROM teacher where teacher_id = ?";
        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);

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

    @Override
    public Teacher add(Teacher entity) {
        String sql = "INSERT INTO teacher VALUES (?, ?, ?, ?)";
        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, entity.getId());
            ps.setString(2, entity.getProject().getId());
            ps.setString(3, entity.getFirstName());
            ps.setString(4, entity.getLastName());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher remove(String id) {
        String sql = "DELETE FROM teacher WHERE teacher_id =?";
        try {
            Connection connection =  ConnectorPostgre.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Teacher> findAll() {
        String sql = "SELECT * FROM teacher";
        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
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

    @Override
    public Teacher update(Teacher entity) {
        String sql = "UPDATE teacher SET project_id=?, firstname=?, lastname=? where teacher_id =?";
        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, entity.getProject().getId());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
