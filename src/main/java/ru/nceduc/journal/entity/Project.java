package ru.nceduc.journal.entity;

import java.util.Date;

public class Project extends AbstractEntity {

    public Project(String id) {
        super(id);
    }
    public Project(String id, Date createDate) {
        super(id,createDate);
    }
}


