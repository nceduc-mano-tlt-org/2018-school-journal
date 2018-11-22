package ru.nceduc.journal;

import java.util.ArrayList;

public class Group extends BusinessEntity{
    private String NameOfGroup;
    private Teacher teacher;
    ArrayList <Student> students;
    Group(Teacher teacher){
        super();           // вызов конструктора BusinessEntity
        //this.section = section;
        this.teacher = teacher;
        students = new ArrayList<Student>();
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public void setStudentList(Student student){
        students.add(student);
    }
    public void setSection(Section section){
        //this.section = section;
    }
    public void setNameOfGroup(String NameOfGroup){
        this.NameOfGroup = NameOfGroup;
    }
    public String getNameOfGroup(){
        return NameOfGroup;
    }
    public void getStudentList(){
        for (Student s : students)
        {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
    }
    public String getNameOfTeacher(){
        return teacher.getFirstName() +  " " + teacher.getLastName();
    }
}
