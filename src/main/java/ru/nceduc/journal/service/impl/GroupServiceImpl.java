package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.service.GroupService;

import java.util.Collection;

public class GroupServiceImpl implements GroupService {

    private JournalDao<Group> groupDao = new GenericInMemoryDao<>();

    @Override
    public Group create() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Group remove(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Group update(Group entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Group find(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Group> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Group> findAllInCurrentProject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void assignToSection(String groupId, String SectionId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reassignSection(String oldSectionId, String newSectionId) {
        throw new UnsupportedOperationException();
    }
}
