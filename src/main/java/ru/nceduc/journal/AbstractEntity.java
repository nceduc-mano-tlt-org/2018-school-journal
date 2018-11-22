package ru.nceduc.journal;

public abstract class AbstractEntity {
    private String id;
    
    public void setID(String id){
        this.id = id;
    }
    public String getID(){
        return id;
    }
}
