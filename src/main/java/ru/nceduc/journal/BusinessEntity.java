package ru.nceduc.journal;


public class BusinessEntity {
    Project project;
    
    BusinessEntity(){
        project = new Project();
    }
    
    public Project getProject(){
        return project;
    }
}
