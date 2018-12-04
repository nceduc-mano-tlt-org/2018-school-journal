package ru.nceduc.journal.entity;

import java.util.ArrayList;
import java.util.List;

public class Section extends BusinessEntity {

    private List<Group> groups;

    public Section(String id, Project project) {
        super(id, project);
        this.groups = new ArrayList<>();
    }

    void addGroup(Group group) {
        this.groups.add(group);
    }

    void removeGroup(Group group) {
        this.groups.remove(group);
    }

    public List<Group> getGroups() {
        return new ArrayList<>(groups);
    }
}
