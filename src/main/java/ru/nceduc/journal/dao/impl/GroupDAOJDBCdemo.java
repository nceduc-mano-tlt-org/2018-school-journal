package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class GroupDAOJDBCdemo implements JournalDao<Group> {

    Connection connection = null;

    public GroupDAOJDBCdemo(Connection connection){
        this.connection = connection;
    }

    private Group getReformedResultSetInSection(ResultSet resultSet) throws SQLException {
        String idGroup = resultSet.getString("group_id");
        Project project = new Project(resultSet.getString("group_project_id"));
        String nameGroup = resultSet.getString("group_name");
        String idSection = resultSet.getString("group_section_id");
        Section section = new Section(idSection,project,"default");
        return new Group(idGroup,project,section,nameGroup);
    }

    @Override
    public Group find(String id) {
        String sql = "SELECT * FROM groups WHERE group_id = ?";
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
    public Group add(Group entity) {
        String sql = "INSERT INTO groups VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getId());
            statement.setString(2, entity.getProject().getId());
            statement.setString(3, entity.getGroupName());
            statement.setString(4, entity.getSection().getId());

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
    public Group remove(String id) {
        Group group = find(id);
        String sql = "DELETE FROM groups WHERE group_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            if (statement.executeUpdate() == 1) {
                statement.close();
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Group> findAll() {
        return null;
    }

    @Override
    public Group update(Group entity) {
        return null;
    }
}
