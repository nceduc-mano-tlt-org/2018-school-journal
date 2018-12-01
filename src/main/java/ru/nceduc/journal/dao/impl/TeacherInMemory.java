package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.TeacherDao;
import ru.nceduc.journal.entity.Teacher;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeacherInMemory implements TeacherDao {
    private Map<String, Teacher> teachers;

    public TeacherInMemory(){
        teachers = new HashMap<>();
    }

    @Override
    public void create(Teacher teacher) {
        teachers.put(teacher.getId(), teacher);
    }

    @Override
    public Teacher read(String id) {
       return teachers.get(id);
    }

    @Override
    public void update(Teacher teacher) {
       Teacher result = teachers.get(teacher.getId());
       result.setProject(teacher.getProject());
       result.setFirstName(teacher.getFirstName());
       result.setLastName(teacher.getLastName());
    }

    @Override
    public void delete(String id) {
        teachers.remove(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers.entrySet()
                .stream()
                .filter(Objects::nonNull)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll(){
        teachers.clear();
    }
}

