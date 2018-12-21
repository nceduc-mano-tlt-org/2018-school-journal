package ru.nceduc.journal;

import ru.nceduc.journal.dao.Connector;
import ru.nceduc.journal.dao.connector.ConnectorPostgre;
import ru.nceduc.journal.service.TeacherService;
import ru.nceduc.journal.service.impl.TeacherServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalApplication {

    public static void main(String args[]) throws SQLException {
        Connector gg = new ConnectorPostgre();
        String url = "jdbc:postgresql://thirdmadman.ddns.net:5432/school-journal";
        final String username = "nctest";
        final String password = "5LLgK0jA2nzdKIGt";
        gg.getConnection(url,username,password);
        ResultSet rs = gg.getConnection(url,username,password).createStatement().executeQuery("SELECT * FROM people WHERE surname = 'Doe'");
        while(rs.next()) {

            System.out.printf("%d\t%s\t%s\t%d\n",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4));
        }
    }
}
