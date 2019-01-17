package ru.nceduc.journal;

import ru.nceduc.journal.entity.*;

import ru.nceduc.journal.service.*;
import ru.nceduc.journal.service.impl.*;

import java.io.IOException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ConsoleManager {

   static ProjectService serviceProject = new ProjectServiceImpl();
   static SectionService serviceSection = new SectionServiceImpl();
   static GroupService serviceGroup = new GroupServiceImpl();
   static StudentService serviceStudent = new StudentServiceImpl();
   static TeacherService serviceTeacher = new TeacherServiceImpl();

    public static void mainFunction() {


        Scanner in = new Scanner(System.in);
        String[] Arguments = null;
        boolean flag = true;
        while(flag){
        Arguments = in.nextLine().toString().split(" ");
            switch (Arguments[0]) {
                case ("csection"):
                    createSection(Arguments);
                    break;
                case ("rsection"):
                    removeSection(Arguments);
                    break;
                case ("fsection"):
                    findSection(Arguments);
                    break;
                case ("usection"):
                    updateSection(Arguments);
                    break;
                case ("fallsection"):
                    findAllSection();
                    break;
                case ("ficpsection"):
                    findAllSectionInCurrentProject();
                    break;
                case ("cproject"):
                    createProject();
                    break;
                case ("rproject"):
                    removeProject(Arguments);
                    break;
                case ("fproject"):
                    findProject(Arguments);
                    break;
                case ("cgroup"):
                    createGroup(Arguments);
                    break;
                case ("rgroup"):
                    removeGroup(Arguments);
                    break;
                case ("fgroup"):
                    findGroup(Arguments);
                    break;
                case ("cstudent"):
                    createStudent(Arguments);
                    break;
                case ("rstudent"):
                    removeStudent(Arguments);
                    break;
                case ("fstudent"):
                    findStudent(Arguments);
                    break;
                case ("cteacher"):
                    createTeacher(Arguments);
                    break;
                case ("rteacher"):
                    removeTeacher(Arguments);
                    break;
                case ("fteacher"):
                    findTeacher(Arguments);
                    break;
                case ("exit"):
                    flag = false;
                    break;
                default:
                    System.out.println("csection    [NameSection]            | [Создание сущности Section]");
                    System.out.println("rsection    [id]                     | [Удаление сущности Section по id ]");
                    System.out.println("fsection    [id]                     | [Поиск сущности Section по id ]");
                    System.out.println("usection    [idSection] [idProject] [NameSection] | [Поиск сущности по id Section]");
                    System.out.println("fallsection [not]                    | [Вывод всех сущностей в таблице Section]");
                    System.out.println("ficpsection [not]                    | [Вывод всех сущностей в таблице Section принадлежащих текущему проекту]");
                    System.out.println("*          *           *           *           *           *           *");
                    System.out.println("cproject    [not]                    | [Создание сущности Project]");
                    System.out.println("rproject    [id]                     | [Удаление сущности Project по id]");
                    System.out.println("fproject    [id]                     | [Поиск сущности Project по id]");
                    System.out.println("*          *           *           *           *           *           *");
                    System.out.println("cgroup      [NameGroup] [Section id] | [Создание сущности Group]");
                    System.out.println("rgroup      [id]                     | [Удаление сущности Group по id]");
                    System.out.println("fgroup      [id]                     | [Поиск сущности Group по id]");
                    System.out.println("*          *           *           *           *           *           *");
                    System.out.println("cstudent    [FirstName] [LastName]   | [Создание сущности Student]");
                    System.out.println("rstudent    [id]                     | [Удаление сущности Student по id]");
                    System.out.println("fstudent    [id]                     | [Поиск сущности Student по id]");
                    System.out.println("*          *           *           *           *           *           *");
                    System.out.println("cteacher    [FirstName] [LastName]   | [Создание сущности Teacher]");
                    System.out.println("rteacher    [id]                     | [Удаление сущности Teacher по id]");
                    System.out.println("fteacher    [id]                     | [Поиск сущности Teacher по id]");
                    break;
            }
        }
    }

    public static void createSection(String[] Arguments) {
        Section expected = serviceSection.createSection(Arguments[1]);
        if (expected != null) {
            System.out.format("Created section! id:%s | project id:%s | name:%s ",expected.getId(),expected.getProject().getId(),expected.getSectionName());
        } else {

        }System.out.println("ERROR! Что-то пошло не так...");
    }

    public static void removeSection(String[] Arguments) {
        Section expected = serviceSection.remove(Arguments[1]);
        if (expected != null) {
            System.out.format("Removed section! id:%s | project id:%s | name:%s ",expected.getId(),expected.getProject().getId(),expected.getSectionName());
        } else {
            System.out.println("Данной сущности section не существует");
        }
    }
    public static void findSection(String[] Arguments) {
        Section expected = serviceSection.find(Arguments[1]);
        if (expected != null) {
            System.out.format("Result find! id:%s | project id:%s | name:%s ",expected.getId(),expected.getProject().getId(),expected.getSectionName());
        } else {
            System.out.println("Результат поиска пуст.");
        }
    }
    public static void updateSection(String[] Arguments) {
        Project project = new Project(Arguments[2]);
        Section section = new Section(Arguments[1],project,Arguments[3]);
        Section expected = serviceSection.update(section);
        if (expected != null) {
            System.out.format("Updating successfully! id:%s | project id:%s | name:%s ",expected.getId(),expected.getProject().getId(),expected.getSectionName());
        } else {
            System.out.println("ERROR! Не удалось произвести обновление");
        }
    }
    public static void findAllSection() {
        Collection<Section> allSections = serviceSection.findAll();
        if (allSections.size() != 0) {
            System.out.println("Result find all:");
            for(Section item : allSections) {
                System.out.format("id:%s | project id:%s | name:%s \n",item.getId(),item.getProject().getId(),item.getSectionName());
            }
        } else {
            System.out.println("Таблица Sections пустая.");
        }
    }
    public static void findAllSectionInCurrentProject() {
        Collection<Section> allSections = serviceSection.findAllInCurrentProject();
        if (allSections.size() != 0) {
            System.out.println("Result find all in current project:");
            for(Section item : allSections) {
                System.out.format("id:%s | project id:%s | name:%s \n",item.getId(),item.getProject().getId(),item.getSectionName());
            }
        } else {
            System.out.println("Таблица Sections не содержит сущностей принадлежащих данному проекту.");
        }
    }
    public static void createProject() {
        Project expected = serviceProject.createNewProject();
        if (expected != null) {
            System.out.format("Created project! id:%s | date:%s | name:%s ",expected.getId(),expected.getCreatedDate(),expected.getNameProject());
        } else {
            System.out.println("ERROR! Что-то пошло не так...");
        }
    }
    public static void removeProject(String[] Arguments) {
        Project expected = serviceProject.remove(Arguments[1]);
        if (expected != null) {
            System.out.format("Removed project! id:%s | date:%s | name:%s ",expected.getId(),expected.getCreatedDate(),expected.getNameProject());
        } else {
            System.out.println("Данной сущности project не существует.");
        }
    }
    public static void findProject(String[] Arguments) {
        Project expected = serviceProject.find(Arguments[1]);
        if (expected != null) {
            System.out.format("Result find! id:%s | date:%s | name:%s ",expected.getId(),expected.getCreatedDate(),expected.getNameProject());
        } else {
            System.out.println("Результат поиска пуст.");
        }
    }
    public static void createGroup(String [] Arguments) {
        Group expected = serviceGroup.createGroup(Arguments[1],Arguments[2]);
        if (expected != null) {
            System.out.format("Created group! id:%s | project id:%s | section id:%s | name:%s ",expected.getId(),expected.getProject().getId(),expected.getSection().getId(),expected.getGroupName());
        } else {
            System.out.println("ERROR! Что-то пошло не так...");
        }
    }
    public static void removeGroup(String[] Arguments) {
        Group expected = serviceGroup.remove(Arguments[1]);
        if (expected != null) {
            System.out.format("Removed group! id:%s | project id:%s | section id:%s | name:%s ",expected.getId(),expected.getProject().getId(),expected.getSection().getId(),expected.getGroupName());
        } else {
            System.out.println("Данной сущности group не существует.");
        }
    }
    public static void findGroup(String[] Arguments) {
        Group expected = serviceGroup.find(Arguments[1]);
        if (expected != null) {
            System.out.format("Result find! id:%s | project id:%s | section id:%s | name:%s ",expected.getId(),expected.getProject().getId(),expected.getSection().getId(),expected.getGroupName());
        } else {
            System.out.println("Результат поиска пуст.");
        }
    }
    public static void createStudent(String [] Arguments) {
        Student expected = serviceStudent.createStudent(Arguments[1],Arguments[2]);
        if (expected != null) {
            System.out.format("Created student! id:%s | project id:%s | first name:%s | last name:%s ",expected.getId(),expected.getProject().getId(),expected.getFirstName(),expected.getLastName());
        } else {
            System.out.println("ERROR! Что-то пошло не так...");
        }
    }
    public static void removeStudent(String[] Arguments) {
        Student expected = serviceStudent.remove(Arguments[1]);
        if (expected != null) {
            System.out.format("Removed student! id:%s | project id:%s | first name:%s | last name:%s ",expected.getId(),expected.getProject().getId(),expected.getFirstName(),expected.getLastName());
        } else {
            System.out.println("Данной сущности student не существует.");
        }
    }
    public static void findStudent(String[] Arguments) {
        Student expected = serviceStudent.find(Arguments[1]);
        if (expected != null) {
            System.out.format("Result student! id:%s | project id:%s | first name:%s | last name:%s ",expected.getId(),expected.getProject().getId(),expected.getFirstName(),expected.getLastName());
        } else {
            System.out.println("Результат поиска пуст.");
        }
    }
    public static void createTeacher(String [] Arguments) {
        Teacher expected = serviceTeacher.createTeacher(Arguments[1],Arguments[2]);
        if (expected != null) {
            System.out.format("Created teacher! id:%s | project id:%s | first name:%s | last name:%s ",expected.getId(),expected.getProject().getId(),expected.getFirstName(),expected.getLastName());
        } else {
            System.out.println("ERROR! Что-то пошло не так...");
        }
    }
    public static void removeTeacher(String[] Arguments) {
        Teacher expected = serviceTeacher.remove(Arguments[1]);
        if (expected != null) {
            System.out.format("Removed teacher! id:%s | project id:%s | first name:%s | last name:%s ",expected.getId(),expected.getProject().getId(),expected.getFirstName(),expected.getLastName());
        } else {
            System.out.println("Данной сущности student не существует.");
        }
    }
    public static void findTeacher(String[] Arguments) {
        Teacher expected = serviceTeacher.find(Arguments[1]);
        if (expected != null) {
            System.out.format("Result teacher! id:%s | project id:%s | first name:%s | last name:%s ",expected.getId(),expected.getProject().getId(),expected.getFirstName(),expected.getLastName());
        } else {
            System.out.println("Результат поиска пуст.");
        }
    }
}
