package ru.nceduc.journal;


public class JournalApplication {

    public static void main(String args[]) {
            Project projectOne = new Project("1");
            Section sectionOne = new Section("1",projectOne);
            Group groupOne = new Group("1",projectOne,sectionOne);
            Teacher teacherOne = new Teacher("1",projectOne,"Иван","Иванов");

            groupOne.setTeacher(teacherOne);

            Student studentOne = new Student("1",projectOne,"Дмитрий","Лопатин");
            Student studentSecond = new Student("1",projectOne,"Максим","Лесовский");
            Student studentThird = new Student("1",projectOne,"Илья","Мазурин");

            groupOne.addStudent(studentOne);
            groupOne.addStudent(studentSecond);
            groupOne.addStudent(studentThird);

            System.out.println("Учитель:");
            System.out.println(groupOne.getTeacher().getFirstName() + " " + groupOne.getTeacher().getLastName());
            System.out.println("Студенты:");
            for (Student s: groupOne.getStudents()) {
                System.out.println(s.getFirstName() + " " + s.getLastName());
            }

    }
}
