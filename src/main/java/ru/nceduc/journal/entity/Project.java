package ru.nceduc.journal.entity;

import lombok.Getter;
import lombok.Setter;


public class Project extends AbstractEntity {
    @Setter @Getter
    private String name;

    public Project(String id) {
        super(id);
        this.name = "Noname project";
    }
}


