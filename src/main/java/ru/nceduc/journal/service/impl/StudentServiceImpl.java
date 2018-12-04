package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Student;
import ru.nceduc.journal.service.StudentService;

import java.util.Collection;

public class StudentServiceImpl implements StudentService {

    private JournalDao<Student> studentDao = new GenericInMemoryDao<>();

    @Override
    public Student save() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Student remove(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Student update(Student entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Student find(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Student> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Student> findAllInCurrentProject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void assignToGroup(String studentId, String groupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reassignGroup(String oldGroupId, String newGroupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAssignment(String studentId, String groupId) {
        throw new UnsupportedOperationException();
    }
}
