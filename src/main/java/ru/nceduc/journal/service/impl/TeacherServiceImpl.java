package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.service.TeacherService;

import java.util.Collection;

public class TeacherServiceImpl implements TeacherService {

    private JournalDao<Teacher> teacherDao = new GenericInMemoryDao<>();

    @Override
    public Teacher create() {
        return null;
    }

    @Override
    public Teacher remove(String id) {
        return null;
    }

    @Override
    public Teacher update(Teacher entity) {
        return null;
    }

    @Override
    public Teacher find(String id) {
        return null;
    }

    @Override
    public Collection<Teacher> findAll() {
        return null;
    }

    @Override
    public Collection<Teacher> findAllInCurrentProject() {
        return null;
    }

    @Override
    public void assignToGroup(String teacherId, String groupId) {

    }

    @Override
    public void reassignGroup(String oldGroupId, String newGroupId) {

    }
}
