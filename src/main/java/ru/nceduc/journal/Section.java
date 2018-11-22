package ru.nceduc.journal;

import java.util.List;

public class Section extends BusinessEntity {

    private List<Group> groups = null;

    public void addGroup(Group group) {
        this.groups.add(group);
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
