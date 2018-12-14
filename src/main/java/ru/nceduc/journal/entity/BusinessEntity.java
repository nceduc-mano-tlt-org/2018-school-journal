package ru.nceduc.journal.entity;

import lombok.Getter;

@Getter
public abstract class BusinessEntity extends AbstractEntity {

    private Project project;

    public BusinessEntity(String id, Project project) {
        super(id);
        this.project = project;
    }
}
