package ru.nceduc.journal.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements Assignable<Group> {

    private List<Group> groups;

    public Teacher(String id, Project project, String firstName, String lastName) {
        super(id, project, firstName, lastName);
        this.groups = new ArrayList<>();
    }

    public List<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    @Override
    public void assignTo(Group group) {
        if (!this.groups.contains(group)) {
            this.groups.add(group);
            group.addTeacher(this);
        }
    }

    @Override
    public void removeAssignment(Group group) {
        if (this.groups.size() > 1) {
            this.groups.remove(group);
            group.removeTeacher(this);
        }
    }

    @Override
    public void reassign(Group source, Group target) {
        assignTo(target);
        removeAssignment(source);
    }
}
