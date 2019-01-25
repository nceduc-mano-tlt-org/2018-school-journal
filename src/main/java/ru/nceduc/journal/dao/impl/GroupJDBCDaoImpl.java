package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.connector.ConnectorPostgre;
import ru.nceduc.journal.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupJDBCDaoImpl implements JournalDao<Group> {

    private Group getFormed (ResultSet resultSet) throws SQLException {

        String id = resultSet.getString("GROUP_id");
        String groupName = resultSet.getString("GROUPNAME");


        //Teacher and Project
        String projectId = resultSet.getString("project_id");
        Project project = new Project(projectId);
        String teacherId = resultSet.getString("teacherId");
        String firstNameTeachers = resultSet.getString("firstNameTeachers");
        String lastNameTeachers = resultSet.getString("lastNameTeachers");
        Teacher teacher = new Teacher(teacherId,project,firstNameTeachers,lastNameTeachers);

        //Student
        String studentId = resultSet.getString("studentId");
        String firstNameStudent = resultSet.getString("firstNameStudent");
        String lastNameStudent = resultSet.getString("lastNameStudent");
        Student student = new Student(studentId,project,firstNameStudent,lastNameStudent);

        //Section
        String sectionId = resultSet.getString("sectionId");
        String sectionName = resultSet.getString("sectionName");
        Section section = new Section(sectionId, project, sectionName);

        return new Group(id,project,section,groupName);

    }


    @Override
    public Group find(String id) {
        String sql = "SELECT * FROM GROUP WHERE GROUP_ID = ?";

        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                statement.close();
                return getFormed(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group add(Group entity) {
        String sql = "INSERT INTO SECTIONS VALUES (?, ?, ?, ?)";

        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,entity.getId());
            statement.setString(2,entity.getProject().getId());//добавить в конструктор имя или пользоваться id ?
            statement.setString(3,entity.getSection().getSectionName());
            statement.setString(4,entity.getGroupName());

            if (statement.executeUpdate() == 1){
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
        String sql = "DELETE FROM GROUP WHERE GROUP_ID = ?";

        try{
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Group> findAll() {
        String sql = "DELETE FROM GROUP WHERE GROUP_ID = ?";

        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.getResultSet();
            List<Group> findAllGroup = new ArrayList<>();
            while (resultSet.next()){
                findAllGroup.add(getFormed(resultSet));
            }
            statement.close();
            return findAllGroup;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group update(Group entity) {
        String sql = "UPDATE GROUP SET PROJECT_ID=?,NAME_SECTION =? , NAME_GROUP =? WHERE GROUP_ID = ?";

        try {
            Connection connection = ConnectorPostgre.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,entity.getProject().getId());
            statement.setString(2,entity.getSection().getSectionName());
            statement.setString(3,entity.getGroupName());
            statement.setString(4,entity.getId());// ?

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
