package ru.nceduc.journal.dao.impl;

import org.apache.commons.lang3.StringUtils;
import ru.nceduc.journal.dao.connector.ConnectorEmbededDao;
import ru.nceduc.journal.dao.connector.ConnectorPostgresqlDao;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.dao.JournalDao;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ProjectDaoJDBC implements JournalDao<Project> {

    // Connection connection = ConnectorEmbeddedBDH2.getSingleton().getConnection();
    Connection connection = null;

    public ProjectDaoJDBC(boolean isTest) {
        if (isTest) {
            connection = ConnectorEmbededDao.getInstance().getConnection();
            try {
                String sql = "DROP TABLE IF EXISTS project;\n" +
                        "CREATE TABLE project (\n" +
                        "    project_id text NOT NULL,\n" +
                        "    project_created_date text NOT NULL,\n" +
                        "    project_modified_date text,\n" +
                        "    project_name text,\n" +
                        ");";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.executeUpdate();

//                sql = "INSERT INTO project (project_id, project_created_date, project_modified_date, project_name) VALUES\n" +
//                        "('1',\t'2019-01-08',\t'2019-01-08', 'MyProject');";
//                statement = connection.prepareStatement(sql);
//                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            connection = ConnectorPostgresqlDao.getInstance().getConnection();
        }
    }

    public ProjectDaoJDBC() {
        connection = ConnectorPostgresqlDao.getInstance().getConnection();
    }

    private String formatDate(Date date) {
        //java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(date.getTime());
        //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(sq);
    }

    private Date stringToDate(String date) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Project find(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("The ID must not be null");
        }
        String sql = "SELECT * FROM project WHERE project_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Project project = new Project(id);
                project.setCreatedDate(stringToDate(resultSet.getString(2)));
                project.setName(resultSet.getString(4));
                project.setModifiedDate(stringToDate(resultSet.getString(3)));
                System.out.println("====find=====");
                System.out.printf("%s\t%s\t%s\t%s\t\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
                return project;
            }
            else {
                System.out.println("=========");
                System.out.println("Nothing found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Project add(Project entity) {
        if (entity == null || StringUtils.isEmpty(entity.getId())) {
            throw new IllegalArgumentException("Neither entity nor ID must not be null");
        }

        String sql = "INSERT INTO project VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getId());
            statement.setString(2, formatDate(entity.getCreatedDate()));
            statement.setString(3, formatDate(entity.getModifiedDate()));
            statement.setString(4, entity.getName());
            if (statement.executeUpdate() == 1) {
                statement.close();
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Project remove(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("The ID must not be null");
        }
        String sql = "DELETE FROM project WHERE project_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            if (statement.executeUpdate() == 1) {
                statement.close();
                return null; // зачем возращать сущьность?
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Collection<Project> findAll() {
        ArrayList out = new ArrayList<Project>();
        String sql = "SELECT * FROM project";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Project> all = new ArrayList<>();
            System.out.println("=====find all====");
            while(resultSet.next()){
                Project project = new Project(resultSet.getString(1));
                project.setCreatedDate(stringToDate(resultSet.getString(2)));
                project.setName(resultSet.getString(4));
                project.setModifiedDate(stringToDate(resultSet.getString(3)));
                System.out.printf("%s\t%s\t%s\t%s\t\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
                out.add(project);
            }
            statement.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Project update(Project entity) {
        if (entity == null || StringUtils.isEmpty(entity.getId())) {
            throw new IllegalArgumentException("Neither entity nor ID must not be null");
        }
        try {
            String sql = "UPDATE project SET project_modified_date =?, project_name = ? WHERE project_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, formatDate(entity.getModifiedDate()));
            statement.setString(2, entity.getName());
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
