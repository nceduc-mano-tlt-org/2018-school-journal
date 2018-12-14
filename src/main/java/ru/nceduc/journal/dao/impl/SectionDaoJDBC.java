package ru.nceduc.journal.dao.impl;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.dao.JournalDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SectionDaoJDBC implements JournalDao<Section>{

    private Section getReformedResultSetInSection(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("SECTION_ID");
        Project project = new Project(resultSet.getString("PROJECT_ID"));
        String name = resultSet.getString("NAME_SECTION");

        return new Section(id, project, name);
    }

    @Override
    public Section find(String id) {
        Connection connection = ConnectorOracle.getSingleton().getConnection();
        String sql = "SELECT * FROM SECTIONS WHERE SECTION_ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                statement.close();
                return getReformedResultSetInSection(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Section add(Section entity) {
        Connection connection = ConnectorOracle.getSingleton().getConnection();
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
    public Section remove(String id) {
        Connection connection = ConnectorOracle.getSingleton().getConnection();
        Section section = find(id);
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
        Connection connection = ConnectorOracle.getSingleton().getConnection();
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
    public Section update(Section entity) {
        Connection connection = ConnectorOracle.getSingleton().getConnection();
        try {
            String sql = "UPDATE teacher SET PROJECT_ID=?,NAME_SECTION =? WHERE SECTION_ID = ?";
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
