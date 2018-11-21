package ru.nceduc.journal;

import java.util.Date;

public class Project extends AbstractEntity {

    private Date createdDate = null;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}


