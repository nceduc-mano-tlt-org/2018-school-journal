package ru.nceduc.journal;

public class JournalApplication {

    public static void main(String[] args) {
       Section section1 = new Section();
       section1.setNameOfSection("����");
       Section section2 = new Section();
       section2.setNameOfSection("���������");
       Section section3 = new Section();
       section3.setNameOfSection("������");
       
       Teacher teacher1 = new Teacher();
       teacher1.setFirstName("����");
       teacher1.setLastName("������");
       
       Student student1 = new Student();
       Student student2 = new Student();
       Student student3 = new Student();
       
       student1.setFirstName("������");
       student1.setLastName("�����");
       student2.setFirstName("�������");
       student2.setLastName("��������");
       student3.setFirstName("����");
       student3.setLastName("�������");
       
       Group group1 = new Group(teacher1);
       section1.setGroupList(group1);
       group1.setStudentList(student1);
       group1.setStudentList(student2);
       group1.setStudentList(student3);
       
       group1.getStudentList();

       System.out.println("�������:");
       System.out.println(group1.getNameOfTeacher());
       
       System.out.println("������������ ������:");
       System.out.println(section1.getNameOfSection());

    }
}
