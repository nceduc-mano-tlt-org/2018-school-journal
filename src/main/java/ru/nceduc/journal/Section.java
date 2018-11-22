package ru.nceduc.journal;

import java.util.ArrayList;
import java.util.List;

public class Section extends BusinessEntity{
    ArrayList <Group> groups;
    private String NameOfSection;
    
    Section(){
       super();         // вызов конструктора BusinessEntity
       groups = new ArrayList<Group>();
    }
 
    public void setGroupList(Group group){
        groups.add(group);
    }
    public void setNameOfSection(String NameOfSection){
        this.NameOfSection = NameOfSection;
    }
    public String getNameOfSection(){
        return NameOfSection;
    }
    public List<Group> getGroupList(){
        return groups;
    }
}