package ru.nceduc.journal.dao.impl;
import ru.nceduc.journal.dao.connector.ConnectorPostgresqlDao;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.dao.JournalDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProjectDaoJDBC implements JournalDao<Project>{

   // Connection connection = ConnectorEmbeddedBDH2.getSingleton().getConnection();
    Connection connection = ConnectorPostgresqlDao.getInstance().getConnection();

/*    private Project getReformedResultSetInSection(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("section_id");
        Project project = new Project(resultSet.getString("section_project_id"));
        String name = resultSet.getString("section_name");

        return new Section(id, project, name);
    }*/

    @Override
    public Project find(String id) {
        String sql = "SELECT * FROM SECTIONS WHERE SECTION_ID = ?";
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
        String sql = "INSERT INTO SECTIONS VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getId());
            statement.setString(2, entity.getProject().getId());
            statement.setString(3, entity.getSectionName());

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
        Project section = find(id);
        String sql = "DELETE FROM SECTIONS WHERE SECTION_ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            if (statement.executeUpdate() == 1) {
                statement.close();
                return section;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Section> findAll() {
        String sql = "SELECT * FROM SECTIONS";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Section> allSections = new ArrayList<>();
            while(resultSet.next()){
                allSections.add(getReformedResultSetInSection(resultSet));
            }
            statement.close();
            return allSections;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Project update(Project entity) {
        try {
            String sql = "UPDATE sections SET section_project_id=?,section_name =? WHERE section_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getProject().getId());
            statement.setString(2, entity.getSectionName());
            statement.setString(3, entity.getId());
            if (statement.executeUpdate() == 1) {
                statement.close();
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
