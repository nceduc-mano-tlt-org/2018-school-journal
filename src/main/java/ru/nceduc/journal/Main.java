package ru.nceduc.journal;
public class Main{
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Слава");
        System.out.println(person.getFirstName());
        person.setLastName("Рыбин");
        System.out.println(person.getLastName());
        person.setId("1");
        System.out.println(person.getId());

    }
}