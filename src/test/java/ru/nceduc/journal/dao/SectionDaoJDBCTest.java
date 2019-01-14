package ru.nceduc.journal.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.impl.ConnectorEmbeddedBDH2;
import ru.nceduc.journal.dao.impl.SectionDaoJDBC;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

public class SectionDaoJDBCTest {
    private JournalDao<Section> dao;
    Connection connection = null;

    @Before
    public void setUp() {
        try {
           dao = new SectionDaoJDBC(ConnectorEmbeddedBDH2.getSingleton().getConnection());
           connection = ConnectorEmbeddedBDH2.getSingleton().getConnection();
           String pathsProjectSQL = "src/test/java/ru/nceduc/journal/dao/impl/CreateTableProjects.sql";
           String pathsSectionSQL = "src/test/java/ru/nceduc/journal/dao/impl/CreateTableSections.sql";

           String sql = new String(Files.readAllBytes(Paths.get(pathsProjectSQL)));
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.executeUpdate();

           sql = new String(Files.readAllBytes(Paths.get(pathsSectionSQL)));
           statement = connection.prepareStatement(sql);
           statement.executeUpdate();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @After
    public void cleanUp() {
        try {
        String dropProjectsTableSQL = "DROP TABLE projects";
        String dropSectionsTableSQL = "DROP TABLE sections";
        PreparedStatement statement = connection.prepareStatement(dropProjectsTableSQL);
        statement.executeUpdate();

        statement = connection.prepareStatement(dropSectionsTableSQL);
        statement.executeUpdate();

        connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void find() {
        UUID uuidProject = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        UUID uuidSection = UUID.fromString("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Project project = new Project(uuidProject.toString());
        Section actualSection = new Section (uuidSection.toString(),project,"Бокс");
        dao.add(actualSection);


        Section expected = dao.find("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Assert.assertEquals(expected.getId(), actualSection.getId());
        Assert.assertEquals(expected.getProject().getId(), actualSection.getProject().getId());
        Assert.assertEquals(expected.getSectionName(), actualSection.getSectionName());
    }

    @Test
    public void add() {
        UUID uuidProject = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        UUID uuidSection = UUID.fromString("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Project project = new Project(uuidProject.toString());
        Section actualSection = new Section (uuidSection.toString(),project,"Бокс");
        dao.add(actualSection);

        Section expected = dao.find("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Assert.assertEquals(expected.getId(), actualSection.getId());
        Assert.assertEquals(expected.getProject().getId(), actualSection.getProject().getId());
        Assert.assertEquals(expected.getSectionName(), actualSection.getSectionName());
    }

    @Test
    public void remove() {
        UUID uuidProject = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        UUID uuidSection = UUID.fromString("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Project project = new Project(uuidProject.toString());
        Section actualSection = new Section (uuidSection.toString(),project,"Бокс");
        dao.add(actualSection);

        Section expected = dao.remove("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        Assert.assertEquals(expected.getId(), actualSection.getId());
        Assert.assertEquals(expected.getProject().getId(), actualSection.getProject().getId());
        Assert.assertEquals(expected.getSectionName(), actualSection.getSectionName());
    }

    @Test
    public void findAll() {
        UUID uuidProject = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        Project project = new Project(uuidProject.toString());
        Section sectionOne = new Section (UUID.randomUUID().toString(),project,"Бокс");
        Section sectionSec = new Section (UUID.randomUUID().toString(),project,"Музыка");
        Section sectionThird = new Section (UUID.randomUUID().toString(),project,"Рисование");

        dao.add(sectionOne);
        dao.add(sectionSec);
        dao.add(sectionThird);

        Collection<Section> actual = dao.findAll();

        Assert.assertFalse(actual.isEmpty());
        Assert.assertEquals(3, actual.size());
    }

    @Test
    public void update() {
        UUID uuidProject = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        UUID uuidSectionOne = UUID.fromString("38400001-8cf0-11bd-b23e-10b96e4ef00d");
        UUID uuidSectionSec = UUID.fromString("10000000-8cf0-11bd-b23e-10b96e4ef00d");
        Project project = new Project(uuidProject.toString());
        Section actual = new Section (uuidSectionOne.toString(),project,"Бокс");
        Section expected = new Section (uuidSectionSec.toString(),project,"Музыка");
        dao.add(actual);
        dao.update(expected);

        Assert.assertEquals(expected.getId(), "10000000-8cf0-11bd-b23e-10b96e4ef00d");
        Assert.assertEquals(expected.getProject().getId(), actual.getProject().getId());
        Assert.assertEquals(expected.getSectionName(), "Музыка");

    }
}