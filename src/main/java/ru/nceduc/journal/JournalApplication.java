package ru.nceduc.journal;


public class JournalApplication {

    public static void main(String args[]) {
        Project project = new Project("1");
        Section section = new Section("1", project);
        Teacher t = null;
        Group group = new Group("", project, section);
        group.setTeacher(t);
        System.out.println(group.getTeacher().getLastName());
    }
}
