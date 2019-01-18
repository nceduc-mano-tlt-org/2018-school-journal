package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.ConnectorPostgreDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.dao.impl.TeacherDAOJDBCdemo;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.service.TeacherService;

import java.sql.Connection;
import java.util.Collection;
import java.util.UUID;

public class TeacherServiceImpl implements TeacherService {

    Connection connection = ConnectorPostgreDao.getSingleton().getConnection();

    private JournalDao<Teacher> teacherDao = new TeacherDAOJDBCdemo(connection);

    @Override
    public Teacher remove(String id) {
        return teacherDao.remove(id);
    }

    @Override
    public Teacher update(Teacher entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Teacher find(String id) {
        return teacherDao.find(id);
    }

    @Override
    public Collection<Teacher> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Teacher> findAllInCurrentProject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Teacher createTeacher(String firstName, String lastName) {
        UUID uuidTeacher = UUID.randomUUID();
        UUID uuidProject = UUID.fromString("00000000-0000-0000-0000-000000000000");
        Project project = new Project(uuidProject.toString());
        Teacher teacher = new Teacher(uuidTeacher.toString(),project,firstName,lastName);
        return teacherDao.add(teacher);
    }

    @Override
    public void assignToGroup(String teacherId, String groupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reassignGroup(String oldGroupId, String newGroupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAssignment(String teacherId, String groupId) {
        throw new UnsupportedOperationException();
    }
}
