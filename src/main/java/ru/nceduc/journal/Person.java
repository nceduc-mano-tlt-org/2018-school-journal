package ru.nceduc.journal;
public class Person extends BusinessEntity {
    private String firstName;
    private String lastName;

    public static void setProject(String s) {
    }

    public static void setSection(String s) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
