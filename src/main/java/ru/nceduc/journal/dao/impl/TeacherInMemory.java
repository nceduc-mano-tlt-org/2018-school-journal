package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.TeacherDao;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;

import java.util.HashMap;
import java.util.Map;

public class TeacherInMemory implements TeacherDao {
    private Map<String, Teacher> teachers;

    public TeacherInMemory(){
        teachers = new HashMap<String, Teacher>();
    }

    public void add(Teacher teacher){
        teachers.put(teacher.getId(), teacher);
    }

    public void create(String id,
                          Project project,
                          String firstName,
                          String lastName) {
        Teacher teacher = new Teacher(id, null, firstName, lastName);
        teachers.put(id, teacher);
    }

    public Teacher read(String id) {
       return teachers.get(id);
    }

    public void update(Teacher teacher) {
        //  teachers.get(teacher.getId()).setProject(teacher.getProject());
        String id = teacher.getId();
        teachers.get(id).setFirstName(teacher.getFirstName());
        teachers.get(id).setLastName(teacher.getLastName());
    }

    public void delete(Teacher teacher) {
        teachers.remove(teacher.getId());
    }

    public void deleteById(String id) {
        teachers.remove(id);
    }

    public Map<String, Teacher> getAll() {
        return teachers;
    }
}

