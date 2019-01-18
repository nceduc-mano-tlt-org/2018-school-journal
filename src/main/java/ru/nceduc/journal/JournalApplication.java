package ru.nceduc.journal;


import ru.nceduc.journal.dao.connector.ConnectorEmbededDao;
import ru.nceduc.journal.dao.impl.ProjectDaoJDBC;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.service.impl.ProjectServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JournalApplication {

    public static void main(String args[]) {

/*        ProjectDaoJDBC pdjdbc = new ProjectDaoJDBC(true);
        ProjectServiceImpl psi = new ProjectServiceImpl(true);



        psi.findAll();
        Project project2 = psi.createNewProject();
        psi.findAll();
        project2.setName("My Second Project");
        psi.update(project2);
        psi.findAll();
        project2.setName("My Second Project edited");
        psi.update(project2);
        psi.findAll();
        psi.remove(project2.getId());
        psi.findAll();*/
    }
}
