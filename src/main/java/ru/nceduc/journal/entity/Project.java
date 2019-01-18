package ru.nceduc.journal.entity;

import lombok.Getter;
import lombok.Setter;

public class Project extends AbstractEntity {
    @Getter@Setter
    private String nameProject;
    public Project(String id) {
        super(id);
        this.nameProject = "default";
    }
}


