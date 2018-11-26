package ru.nceduc.journal.entity;

public abstract class Person extends BusinessEntity {

    private String firstName;
    private String lastName;

    public Person(String id, Project project,
                  String firstName, String lastName) {
        super(id, project);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
