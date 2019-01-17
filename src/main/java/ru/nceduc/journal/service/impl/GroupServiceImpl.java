package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.service.GroupService;

import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;


public class GroupServiceImpl implements GroupService {

    private JournalDao<Group> groupDao = new GenericInMemoryDao<>();

    @Override
    public Group remove(String id) {
        return groupDao.remove(id);
    }

    @Override
    public Group update(Group entity) {
        return groupDao.update(entity);
    }

    @Override
    public Group find(String id) throws SQLException {
        return groupDao.find(id);
    }

    @Override
    public Collection<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public Collection<Group> findAllInCurrentProject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Group createGroup(String name, String sectionId, Project project, Section section) {
        UUID uuid = UUID.randomUUID();
        Group group = new Group(uuid.toString(),project,section,name);
        return groupDao.add(group);
    }

    @Override
    public void assignToSection(String groupId, String SectionId) {
       // groupDao.find(groupId).assignTo();
    }

    @Override
    public void reassignSection(String oldSectionId, String newSectionId) {
        //groupDao.find(oldSectionId).assignTo();
    }
}
