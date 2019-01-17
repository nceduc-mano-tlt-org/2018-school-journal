package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.ConnectorPostgreDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.dao.impl.StudentDAOJDBCdemo;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Student;
import ru.nceduc.journal.service.StudentService;

import java.sql.Connection;
import java.util.Collection;
import java.util.UUID;

public class StudentServiceImpl implements StudentService {

    Connection connection = ConnectorPostgreDao.getSingleton().getConnection();

    private JournalDao<Student> studentDao = new StudentDAOJDBCdemo(connection);

    @Override
    public Student remove(String id) {
        return studentDao.remove(id);
    }

    @Override
    public Student update(Student entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Student find(String id) {
        return studentDao.find(id);
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
    public Student createStudent(String firstName, String lastName) {
        UUID uuidStudent = UUID.randomUUID();
        UUID uuidProject = UUID.fromString("00000000-0000-0000-0000-000000000000");
        Project project = new Project(uuidProject.toString());
        Student student = new Student(uuidStudent.toString(),project,firstName,lastName);
        return studentDao.add(student);
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
