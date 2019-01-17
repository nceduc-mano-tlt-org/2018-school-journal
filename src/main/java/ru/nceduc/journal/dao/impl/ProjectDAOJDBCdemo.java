package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class ProjectDAOJDBCdemo implements JournalDao<Project> {

    Connection connection = null;

    public ProjectDAOJDBCdemo (Connection connection){
        this.connection = connection;
    }

    private Project getReformedResultSetInSection(ResultSet resultSet) throws SQLException {
        String idProject = resultSet.getString("project_id");
        return new Project(idProject);
    }

    @Override
    public Project find(String id) {
        String sql = "SELECT * FROM projects WHERE project_id = ?";
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
    public Project add(Project entity) {
        String sql = "INSERT INTO projects VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getId());
            statement.setString(2, entity.getCreatedDate().toString());
            statement.setString(3, entity.getModifiedDate().toString());
            statement.setString(4, entity.getNameProject());

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
    public Project remove(String id) {
        Project project = find(id);
        String sql = "DELETE FROM projects WHERE project_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            if (statement.executeUpdate() == 1) {
                statement.close();
                return project;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Project> findAll() {
        return null;
    }

    @Override
    public Project update(Project entity) {
        return null;
    }
}
