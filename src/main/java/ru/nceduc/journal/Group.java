package ru.nceduc.journal;

public class Group extends BusinessEntity{

    private Section section;
    private String groupName;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }
}
