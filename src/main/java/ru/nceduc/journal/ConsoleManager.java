package ru.nceduc.journal;

import ru.nceduc.journal.entity.*;
import ru.nceduc.journal.service.*;
import ru.nceduc.journal.service.impl.*;
import java.util.Scanner;

public class ConsoleManager {
    static TeacherService serviceTeacher = new TeacherServiceImpl();

    public static void mainFunction() {
        Scanner in = new Scanner(System.in);
        String[] Arguments = null;
        boolean flag = true;
        while(flag){
            Arguments = in.nextLine().toString().split(" ");
            switch (Arguments[0]) {
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
                    System.out.println("cteacher    [FirstName] [LastName]   | [Создание сущности Teacher]");
                    System.out.println("rteacher    [id]                     | [Удаление сущности Teacher по id]");
                    System.out.println("fteacher    [id]                     | [Поиск сущности Teacher по id]");
                    break;
            }
        }
    }

    public static void createTeacher(String [] Arguments) {
        Teacher expected = serviceTeacher.createTeacher(Arguments[1], Arguments[2]);
        if (expected != null) {
            System.out.format(
                    "Created teacher! id:%s | project id:%s | first name:%s | last name:%s ",
                    expected.getId(),
                    expected.getProject().getId(),
                    expected.getFirstName(),
                    expected.getLastName());
        } else {
            System.out.println("Error! Teacher was not created");
        }
    }
    public static void removeTeacher(String[] Arguments) {
        Teacher expected = serviceTeacher.remove(Arguments[1]);
        if (expected != null) {
            System.out.format(
                    "Removed teacher! id:%s | project id:%s | first name:%s | last name:%s ",
                    expected.getId(),
                    expected.getProject().getId(),
                    expected.getFirstName(),
                    expected.getLastName());
        } else {
            System.out.println("Entity does not exist");
        }
    }
    public static void findTeacher(String[] Arguments) {
        Teacher expected = serviceTeacher.find(Arguments[1]);
        if (expected != null) {
            System.out.format(
                    "Result teacher! id:%s | project id:%s | first name:%s | last name:%s ",
                    expected.getId(),
                    expected.getProject().getId(),
                    expected.getFirstName(),
                    expected.getLastName());
        } else {
            System.out.println("Search result is empty");
        }
    }
}
