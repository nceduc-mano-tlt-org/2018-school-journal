package ru.nceduc.journal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public abstract class AbstractEntity {

    private String id;
    private Date createdDate;
    @Setter
    private Date modifiedDate;
    @Setter
    private String name;

    public AbstractEntity(String id) {
        this.id = id;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
        this.name = "Noname project";
    }

    public AbstractEntity(String id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = new Date();
        this.name = "Noname project";
    }
}
