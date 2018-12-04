package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Assignable;
import ru.nceduc.journal.service.GroupService;

import java.util.Collection;

public class GroupServiceImpl implements GroupService {

    private JournalDao<Group> groupDao = new GenericInMemoryDao<>();

    @Override
    public Group create() {
        return null;
    }

    @Override
    public Group remove(String id) {
        return null;
    }

    @Override
    public Group update(Group entity) {
        return null;
    }

    @Override
    public Group find(String id) {
        return null;
    }

    @Override
    public Collection<Group> findAll() {
        return null;
    }

    @Override
    public Collection<Group> findAllInCurrentProject() {
        return null;
    }

    @Override
    public void assignToSection(String groupId, String SectionId) {

    }

    @Override
    public void reassignSection(String oldSectionId, String newSectionId) {

    }
}
