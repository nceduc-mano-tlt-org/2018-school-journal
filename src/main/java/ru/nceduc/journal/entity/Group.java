package ru.nceduc.journal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Group extends BusinessEntity implements Assignable<Section> {

    @Setter
    private String groupName;
    private Section section;
    private List<Student> students;
    private List<Teacher> teachers;

    public Group(String id, Project project, Section section, String groupName) {
        super(id, project);
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.groupName = groupName;
        assignTo(section);
    }

    void addStudent(Student student) {
        if (!this.students.contains(student))
            this.students.add(student);
    }

    void removeStudent(Student student) {
        this.students.remove(student);
    }

    void addTeacher(Teacher teacher) {
        if (!this.teachers.contains(teacher))
            this.teachers.add(teacher);
    }

    void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
    }

    @Override
    public void assignTo(Section section) {
        this.section = section;
        this.section.addGroup(this);
    }

    @Override
    public void removeAssignment(Section target) {
        throw new IllegalStateException("Group cannot exist without a parent Section.");
    }

    @Override
    public void reassign(Section source, Section target) {
        if (this.section.getId().equals(source.getId())) {
            source.removeGroup(this);
            assignTo(target);
        }
    }
}
