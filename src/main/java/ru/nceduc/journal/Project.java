package ru.nceduc.journal;

import java.util.Date;

public class Project {
    private Date createDate;
    
    Project(){
        createDate = new Date();
    }
    
    public Date getDate(){
        return createDate;
    }
    
    public void setDate(Date date){
        this.createDate = date;
    }
    
}
