package ru.nceduc.journal;

public abstract class Person extends AbstractEntity{
    private String firstname = null;
    private String lastName = null;

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
