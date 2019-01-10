package ru.nceduc.journal;

import ru.nceduc.journal.dao.impl.ConnectorPostgreDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.Date;

public class JournalApplication {

    public static void main(String args[]) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:database");
            String pathsProjectScript = "src/test/java/ru/nceduc/journal/dao/impl/CreateTableSections.sql";
            String sql = null;
            try {
                sql = new String(Files.readAllBytes(Paths.get(pathsProjectScript)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            sql = "INSERT INTO sections VALUES (?,?,?);";
            statement = connection.prepareStatement(sql);
            UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
            UUID uuid2 = UUID.fromString("38400001-8cf0-11bd-b23e-10b96e4ef00d");
            statement.setString(1, uuid.toString());
            statement.setString(2, uuid2.toString());
            statement.setString(3, "Бокс");
            statement.executeUpdate();
           sql = "SELECT * FROM sections";
           statement = connection.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();
           if (resultSet.next()) {
               System.out.println(resultSet.getString("section_id"));
               System.out.println(resultSet.getString("section_project_id"));
               System.out.println(resultSet.getString("section_name"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
