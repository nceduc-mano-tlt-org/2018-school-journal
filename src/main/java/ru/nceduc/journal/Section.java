package ru.nceduc.journal;

import java.util.ArrayList;
import java.util.List;

public class Section extends BusinessEntity {

    private List<Group> groups;

    public Section(String id, Project project) {
        super(id, project);
        this.groups = new ArrayList<Group>();
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object obj) {
        Section section = (Section) obj;
        if (section.getId() == this.getId()
        && section.getProject() == this.getProject()){
            return true;
        }
        return false;
    }
}
