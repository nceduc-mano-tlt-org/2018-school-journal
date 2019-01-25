package ru.nceduc.journal.service.impl;

import org.junit.*;
import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.connector.ConnectorEmbeddedH2;
import ru.nceduc.journal.dao.connector.ConnectorPostgre;
import ru.nceduc.journal.dao.impl.TeacherJDBCDaoImpl;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.service.TeacherService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.*;

public class TeacherServiceImplTest {
    private TeacherService dao;
    Connection connection;
    UUID uuidProject;
    UUID uuidTeacher;
    Teacher actual;
    Teacher expected;
    Teacher newTeacher;

    @BeforeClass
    public void setUpClass() {
        try {
            connection = ConnectorEmbeddedH2.getInstance().getConnection();
            dao = new TeacherServiceImpl();
            String createDbPath = "src/test/resources/create-db.sql";
            String createSchemaPath = "src/test/resources/create-schema.sql";
            String createTablePath = "src/test/resources/create-table.sql";
            String createDataPath = "src/test/resources/create-data.sql";

            String sql = new String(Files.readAllBytes(Paths.get(createDbPath)));
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            sql = new String(Files.readAllBytes(Paths.get(createSchemaPath)));
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            sql = new String(Files.readAllBytes(Paths.get(createTablePath)));
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            sql = new String(Files.readAllBytes(Paths.get(createDataPath)));
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public void tearDownClass() {
        try {
        String dropSectionsTableSQL = "drop database test-postgres";
        PreparedStatement statement = connection.prepareStatement(dropSectionsTableSQL);
        statement.executeUpdate();

        connection = null;
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        UUID uuidProject = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        UUID uuidTeacher = UUID.fromString("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        UUID uuidTeacher2 = UUID.fromString("10000000-8cf0-11bd-b23e-10b96e4ef00d");
        Project project = new Project(uuidProject.toString());

        actual = new Teacher (uuidTeacher.toString(), project,"Alexander", "Alexandrov");
        newTeacher = new Teacher (uuidTeacher2.toString(), project,"Petr", "Popov");

        dao.createTeacher(actual.getId(), actual.getProject(),actual.getFirstName(), actual.getLastName());
        dao.createTeacher(newTeacher.getId(), newTeacher.getProject(), newTeacher.getFirstName(), newTeacher.getLastName());
    }

    @Test
    public void remove() {
        expected = dao.remove("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        actual = dao.find("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getProject().getId(), actual.getProject().getId());
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());
    }

    @Test
    public void update() {
        expected = newTeacher;
        dao.update(newTeacher);
        actual = dao.find("10000000-8cf0-11bd-b23e-10b96e4ef00d");

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getProject().getId(), actual.getProject().getId());
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());
    }

    @Test
    public void find() {
        expected = dao.find("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getProject().getId(), actual.getProject().getId());
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());
    }

    @Test
    public void findAll() {
        Collection<Teacher> actualCollection = dao.findAll();
        Assert.assertFalse(actualCollection.isEmpty());
        Assert.assertEquals(2, actualCollection.size());
    }


}