package ru.nceduc.journal;

import java.util.Date;

public class Project extends AbstractEntity {

    private BusinessEntity entity = null;

    private Date createdDate = null;

    public Project(String id,Date createdDate) {
        this.createdDate = createdDate;
        this.setId(id);
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BusinessEntity getEntity() {
        return entity;
    }

    public void createEntity() {

        this.entity = new BusinessEntity();

    }
}


