package ru.nceduc.journal;

import java.util.ArrayList;
import java.util.List;

public class BusinessEntity {

    private Project project = null;

    private List<Section> sections = new ArrayList<Section>();

    public Project getProject() {
        return project;
    }

/*    public void setProject(Project project) {
        this.project = project;
    }*/

    public void addSection(Section section) {
        sections.add(section);
    }


    public List<Section> getSections() {
        return sections;
    }
}
