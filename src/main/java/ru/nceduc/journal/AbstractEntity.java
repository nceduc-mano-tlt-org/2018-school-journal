package ru.nceduc.journal;

import java.util.Date;

abstract class AbstractEntity {

    private String id;
    private Date createdDate;
    private Date modifiedDate;

    public AbstractEntity(String id) {
        this.id = id;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
