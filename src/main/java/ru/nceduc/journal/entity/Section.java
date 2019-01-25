package ru.nceduc.journal.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Section extends BusinessEntity {

    @Getter@Setter
    private String sectionName;
    private List<Group> groups;

    public Section(String id, Project project, String sectionName) {
        super(id, project);
        this.groups = new ArrayList<>();
        this.sectionName = sectionName;
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
