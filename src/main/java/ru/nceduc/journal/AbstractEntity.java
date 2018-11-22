package ru.nceduc.journal;

import java.util.Date;

abstract class AbstractEntity {
    private String id = null;

    private Project project = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

 }
