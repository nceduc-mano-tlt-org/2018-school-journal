package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.ConnectorPostgreDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.dao.impl.GroupDAOJDBCdemo;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.service.GroupService;

import java.sql.Connection;
import java.util.Collection;
import java.util.UUID;

public class GroupServiceImpl implements GroupService {

    Connection connection = ConnectorPostgreDao.getSingleton().getConnection();

    private JournalDao<Group> groupDao = new GroupDAOJDBCdemo(connection);

    @Override
    public Group remove(String id) {
        return groupDao.remove(id);
    }

    @Override
    public Group update(Group entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Group find(String id) {
        return groupDao.find(id);
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
    public Group createGroup(String name, String sectionId) {
        UUID uuidProject = UUID.fromString("00000000-0000-0000-0000-000000000000");
        UUID uuidGroup = UUID.randomUUID();
        Project project = new Project (uuidProject.toString());
        Section section = new Section(sectionId,project,"default");
        Group group = new Group(uuidGroup.toString(),project,section,name);
        return groupDao.add(group);
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
