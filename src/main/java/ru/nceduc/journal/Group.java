package ru.nceduc.journal;
public class Group extends BusinessEntity {
    Section section;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
