package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Student;
import ru.nceduc.journal.entity.Assignable;
import ru.nceduc.journal.service.StudentService;

import java.util.Collection;

public class StudentServiceImpl implements StudentService {

    private JournalDao<Student> studentDao = new GenericInMemoryDao<>();

    @Override
    public Student create() {
        return null;
    }

    @Override
    public Student remove(String id) {
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public Student find(String id) {
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public Collection<Student> findAllInCurrentProject() {
        return null;
    }

    @Override
    public void assignToGroup(String studentId, String groupId) {

    }

    @Override
    public void reassignGroup(String oldGroupId, String newGroupId) {

    }
}
