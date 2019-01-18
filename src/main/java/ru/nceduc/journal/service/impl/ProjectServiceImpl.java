package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.dao.impl.ProjectDaoJDBC;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.service.ProjectService;

import java.util.Collection;
import java.util.UUID;

public class ProjectServiceImpl implements ProjectService {

    //private JournalDao<Project> projectDao = new GenericInMemoryDao<>();
    private String currentProjectId = null;

    private ProjectDaoJDBC pdjdbc = null;

    public ProjectServiceImpl(boolean istest) {
        if (istest) {
           pdjdbc = new ProjectDaoJDBC(true);
        }
        else {
            pdjdbc = new ProjectDaoJDBC(false);
        }
    }

    public ProjectServiceImpl() {
        pdjdbc = new ProjectDaoJDBC(false);
    }

    @Override
    public Project createNewProject() { // почему нет add?
        UUID uuid = UUID.randomUUID();
        Project project = new Project(uuid.toString());
        currentProjectId = uuid.toString();
        return pdjdbc.add(project);
    }

    public Project setCurrntProject(String id) {
        Project found = pdjdbc.find(id);
        if (found != null) {
            currentProjectId = id;
        }
        return found;
    }

    @Override
    public Project getCurrentProject() {
        return pdjdbc.find(currentProjectId);
    }

    @Override
    public Project remove(String id) {
        return pdjdbc.remove(id);
    }

    @Override
    public Project update(Project entity) {
        return pdjdbc.update(entity);
    }

    @Override
    public Project find(String id) {
        return pdjdbc.find(id);
    }

    @Override
    public Collection<Project> findAll() {
        return pdjdbc.findAll();
    }
}
