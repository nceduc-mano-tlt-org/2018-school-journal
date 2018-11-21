package ru.nceduc.journal;

import java.sql.Date;

public class Project extends AbstractEntity {
    private Date createdData;

    public Date getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }
}
