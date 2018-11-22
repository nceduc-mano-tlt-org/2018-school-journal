package ru.nceduc.journal;

public class JournalApplication {

    public static void main(String[] args) {
       Section section1 = new Section();
       section1.setNameOfSection("Бокс");
       Section section2 = new Section();
       section2.setNameOfSection("Рисование");
       Section section3 = new Section();
       section3.setNameOfSection("Музыка");
       
       Teacher teacher1 = new Teacher();
       teacher1.setFirstName("Иван");
       teacher1.setLastName("Иванов");
       
       Student student1 = new Student();
       Student student2 = new Student();
       Student student3 = new Student();
       
       student1.setFirstName("Андрей");
       student1.setLastName("Рытов");
       student2.setFirstName("Дмитрий");
       student2.setLastName("Анисимов");
       student3.setFirstName("Илья");
       student3.setLastName("Мазурин");
       
       Group group1 = new Group(teacher1);
       section1.setGroupList(group1);
       group1.setStudentList(student1);
       group1.setStudentList(student2);
       group1.setStudentList(student3);
       
       group1.getStudentList();

       System.out.println("Учитель:");
       System.out.println(group1.getNameOfTeacher());
       
       System.out.println("Наименование секции:");
       System.out.println(section1.getNameOfSection());

    }
}
