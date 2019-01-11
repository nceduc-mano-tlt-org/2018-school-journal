package ru.nceduc.journal;

import ru.nceduc.journal.dao.ConnectorDao;
import ru.nceduc.journal.dao.connector.ConnectorPostgresqlDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalApplication {

    public static void main(String args[]) throws SQLException {
        ConnectorDao gg = ConnectorPostgresqlDao.getInstance();
        Connection ic = gg.getConnection();
        ResultSet rs = ic.createStatement().executeQuery("SELECT student_fist_name,student_last_name FROM student");
        while(rs.next()) {
            System.out.printf("%s\t%s\t\n",
                    rs.getString(1),
                    rs.getString(2));
        }
    }
}
