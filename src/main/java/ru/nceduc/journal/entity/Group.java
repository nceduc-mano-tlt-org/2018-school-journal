package ru.nceduc.journal.entity;

import java.util.ArrayList;
import java.util.List;

public class Group extends BusinessEntity {

    private Section section;
    private Teacher teacher;
    private List<Student> students;

    public Group(String id, Project project, Section section) {
        super(id, project);
        this.section = section;
        this.students = new ArrayList<Student>();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
