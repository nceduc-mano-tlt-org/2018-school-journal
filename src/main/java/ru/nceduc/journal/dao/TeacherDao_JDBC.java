package ru.nceduc.journal.dao;

import ru.nceduc.journal.entity.Teacher;

import java.util.List;

public interface TeacherDao_JDBC {
    boolean insertTeacher(Teacher teacher);
    Teacher getTeacher(String teacherId);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(String teacherId);
    List<Teacher> getAllTeachers();
}
