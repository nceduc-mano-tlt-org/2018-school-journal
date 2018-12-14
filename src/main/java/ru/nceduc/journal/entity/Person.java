package ru.nceduc.journal.entity;

import lombok.Data;

@Data
public abstract class Person extends BusinessEntity {

    private String firstName;
    private String lastName;

    public Person(String id, Project project,
                  String firstName, String lastName) {
        super(id, project);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
