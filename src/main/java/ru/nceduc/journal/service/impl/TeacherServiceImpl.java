package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.service.TeacherService;

import java.util.Collection;

public class TeacherServiceImpl implements TeacherService {

    private JournalDao<Teacher> teacherDao = new GenericInMemoryDao<>();

    @Override
    public Teacher remove(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Teacher update(Teacher entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Teacher find(String id) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
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
