package ru.nceduc.journal.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<Group> groups;

    public Teacher(String id, Project project, String firstName, String lastName) {
        super(id, project, firstName, lastName);
        this.groups = new ArrayList<Group>();
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }
}
