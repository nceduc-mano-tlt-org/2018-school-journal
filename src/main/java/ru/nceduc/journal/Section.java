package ru.nceduc.journal;
import java.util.List;

public class Section extends BusinessEntity {
    List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
