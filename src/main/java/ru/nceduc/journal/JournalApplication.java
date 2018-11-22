package ru.nceduc.journal;

import java.util.Date;

public class JournalApplication {

    public static void main (String args[]) {

        Project project = new Project("fff",new Date());
        project.createEntity();
        BusinessEntity entity = project.getEntity();
        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("Andrey");
        Section box = new Section(teacher1);
        box.addGroup(new Group("Box1"));
        entity.addSection(box);


        System.out.println(project.getEntity().getSections().get(0).getGroups().get(0).getGroupName());
        System.out.println(project.getEntity().getSections().get(0).getTeachers().get(0).getFirstname());
    }
}
