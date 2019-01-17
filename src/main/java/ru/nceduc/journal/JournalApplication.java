package ru.nceduc.journal;

import ru.nceduc.journal.dao.bl.ConnectH2;
import ru.nceduc.journal.dao.bl.ConnectorPostgres;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.service.TeacherService;
import ru.nceduc.journal.service.impl.TeacherServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalApplication {

    public static void main(String args[]) {
        Connection connection = null;
        connection = ConnectorPostgres.getConnectorPostgres().getConnection();
    }
}
