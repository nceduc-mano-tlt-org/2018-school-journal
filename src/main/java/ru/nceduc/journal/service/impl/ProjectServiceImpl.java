package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.ConnectorPostgreDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.dao.impl.ProjectDAOJDBCdemo;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.service.ProjectService;

import java.sql.Connection;
import java.util.Collection;
import java.util.UUID;

public class ProjectServiceImpl implements ProjectService {

    Connection connection = ConnectorPostgreDao.getSingleton().getConnection();
    private JournalDao<Project> projectDao = new ProjectDAOJDBCdemo(connection);

    @Override
    public Project createNewProject() {
        UUID uuidProject = UUID.fromString("00000000-0000-0000-0000-000000000000");
        Project project = new Project (uuidProject.toString());
        return projectDao.add(project);
    }

    @Override
    public Project getCurrentProject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Project remove(String id) {
        return projectDao.remove(id);
    }

    @Override
    public Project update(Project entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Project find(String id) {
        return projectDao.find(id);
    }

    @Override
    public Collection<Project> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Project> findAllInCurrentProject() {
        throw new UnsupportedOperationException();
    }
}
