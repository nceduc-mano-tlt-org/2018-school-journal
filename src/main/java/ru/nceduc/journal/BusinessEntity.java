package ru.nceduc.journal;

public abstract class BusinessEntity extends AbstractEntity {

    private Project project;

    public BusinessEntity(String id, Project project) {
        super(id);
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
