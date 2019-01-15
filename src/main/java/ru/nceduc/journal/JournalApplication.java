package ru.nceduc.journal;


import ru.nceduc.journal.dao.impl.ProjectDaoJDBC;
import ru.nceduc.journal.entity.Project;

import java.util.ArrayList;
import java.util.Date;

public class JournalApplication {

    public static void main(String args[]) {

        ProjectDaoJDBC pdjdbc = new ProjectDaoJDBC();

/*        pdjdbc.findAll();
        Project project2 = new Project("2");
        project2.setName("My Second Project");
        pdjdbc.add(project2);
        pdjdbc.findAll();
        project2.setName("My Second Project edited");
        pdjdbc.update(project2);
        pdjdbc.findAll();
        pdjdbc.remove("2");
        pdjdbc.findAll();*/
    }
}
