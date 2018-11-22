package ru.nceduc.journal;

abstract class Person extends BusinessEntity{
    private String firstName;
    private String lastName;
    
    Person(){
        super();    // вызов конструктора BusinessEntity
        
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    
}
