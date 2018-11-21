package ru.nceduc.journal;
public class BusinessEntity extends AbstractEntity {
    Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
