package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.dao.impl.TeacherJDBCDaoImpl;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.service.GroupService;
import ru.nceduc.journal.service.TeacherService;

import java.util.Collection;
import java.util.UUID;

public class TeacherServiceImpl implements TeacherService {

    private JournalDao<Teacher> teacherDao = new TeacherJDBCDaoImpl();
    private GroupService groupService = new GroupServiceImpl();

    @Override
    public Teacher remove(String id) {
        return teacherDao.remove(id);
    }

    @Override
    public Teacher update(Teacher entity) {
        return teacherDao.update(entity);
    }

    @Override
    public Teacher find(String id) {
        return teacherDao.find(id);
    }

    @Override
    public Collection<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Collection<Teacher> findAllInCurrentProject() {
        return null;
    }

    @Override
    public Teacher createTeacher(String id, Project project, String firstName, String lastName) {
        Teacher entity = new Teacher(
                id,
                project,
                firstName,
                lastName);
        return teacherDao.add(entity);
    }

    @Override
    public Teacher createTeacher(String firstName, String lastName) {
        UUID uuidProject = UUID.fromString("00000000-0000-0000-0000-000000000000");
        UUID uuidTeacher = UUID.randomUUID();
        Teacher entity = new Teacher(
                uuidTeacher.toString(),
                new Project(uuidProject.toString()),
                firstName,
                lastName);
        return teacherDao.add(entity);
    }

    @Override
    public void assignToGroup(String teacherId, String groupId) {
        Teacher teacher = teacherDao.find(teacherId);
        Group group = groupService.find(groupId);

        teacher.assignTo(group);
    }

    @Override
    public void reassignGroup(String teacherId, String oldGroupId, String newGroupId) {
        Teacher teacher = teacherDao.find(teacherId);
        Group oldGroup = groupService.find(oldGroupId);
        Group newGroup = groupService.find(newGroupId);

        teacher.removeAssignment(oldGroup);
        teacher.assignTo(newGroup);
    }

    @Override
    public void removeAssignment(String teacherId, String groupId) {
        Teacher teacher = teacherDao.find(teacherId);
        Group group = groupService.find(groupId);

        teacher.removeAssignment(group);
    //    group.removeAssignment(teacher);
    }
}
