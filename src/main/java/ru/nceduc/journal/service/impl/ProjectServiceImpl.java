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
        throw new UnsupportedOperationException();
    }

    @Override
    public Project create() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Project remove(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Project update(Project entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Project find(String id) {
        throw new UnsupportedOperationException();
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
