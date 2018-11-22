package ru.nceduc.journal;

import java.util.ArrayList;
import java.util.List;

public class Section extends BusinessEntity {

    private List<Teacher> teachers = new ArrayList<Teacher>();

    private List<Group> groups = new ArrayList<Group>();

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Section(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
