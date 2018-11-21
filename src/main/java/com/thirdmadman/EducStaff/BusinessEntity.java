package com.thirdmadman.EducStaff;

public abstract class BusinessEntity {
    private Project project = null;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
