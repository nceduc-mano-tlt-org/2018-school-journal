package ru.nceduc.journal.dao.impl;

//import oracle.jdbc.proxy.annotation.Pre;
import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.bl.ConnectH2;
import ru.nceduc.journal.dao.bl.ConnectorBD;
import ru.nceduc.journal.dao.bl.ConnectorPostgres;
import ru.nceduc.journal.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupDaoJDBCImpl implements JournalDao<Group> {
    Connection connection = null;

    public GroupDaoJDBCImpl(Connection connection) {
        this.connection = connection;
    }

    private Group getFormed (ResultSet resultSet) throws SQLException {

        String id = resultSet.getString("group_id");
        String groupName = resultSet.getString("group_name");

        String projectId = resultSet.getString("group_project_id");
        Project project = new Project(projectId);

        //Section
        String sectionId = resultSet.getString("group_section_id");
        String sectionName = resultSet.getString("sectionName");
        Section section = new Section(sectionId,project,sectionName);

        return new Group(id,project,section,groupName);

    }


    @Override
    public Group find(String id) {
        String sql = "SELECT g.group_id ,g.group_name,g.group_project_id,g.group_section_id, s.section_name FROM " +
                "groups g , sections s WHERE group_id=? and g.group_section_id=s.section_id";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return getFormed(resultSet);
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
            statement.setString(1,entity.getId());
            statement.setString(2,entity.getProject().getId());
            statement.setString(3,entity.getGroupName());
            statement.setString(4,entity.getSection().getId());

            if (statement.executeUpdate() == 1){
                return entity;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group remove(String id) {
        String sql = "DELETE FROM GROUPS WHERE GROUP_ID = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Group> findAll() {
        String sql = "DELETE FROM GROUPS WHERE GROUP_ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.getResultSet();
            List<Group> findAllGroup = new ArrayList<>();
            while (resultSet.next()){
                findAllGroup.add(getFormed(resultSet));
            }
            return findAllGroup;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group update(Group entity) {
        String sql = "UPDATE GROUPS SET group_project_id = ?,group_section_id =? , group_name =? WHERE GROUP_ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,entity.getProject().getId());
            statement.setString(2,entity.getSection().getSectionName());
            statement.setString(3,entity.getGroupName());
            statement.setString(4,entity.getId());//

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
