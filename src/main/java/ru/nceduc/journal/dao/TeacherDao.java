package ru.nceduc.journal.dao;

import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;

import java.util.Map;

public interface TeacherDao {

    public void add(Teacher teacher);
    public void create(
            String id,
            Project project,
            String firstName,
            String lastName);
    public Teacher read(String id);
    public void update(Teacher teacher);
    public void delete(Teacher teacher);
    public void deleteById(String id);
    public Map<String, Teacher> getAll();
}
