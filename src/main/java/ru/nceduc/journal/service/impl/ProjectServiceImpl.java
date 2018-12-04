package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.service.ProjectService;

import java.util.Collection;

public class ProjectServiceImpl implements ProjectService {

    private JournalDao<Project> projectDao = new GenericInMemoryDao<>();

    @Override
    public Project getCurrentProject() {
        return null;
    }

    @Override
    public Project create() {
        return null;
    }

    @Override
    public Project remove(String id) {
        return null;
    }

    @Override
    public Project update(Project entity) {
        return null;
    }

    @Override
    public Project find(String id) {
        return null;
    }

    @Override
    public Collection<Project> findAll() {
        return null;
    }

    @Override
    public Collection<Project> findAllInCurrentProject() {
        return null;
    }
}
