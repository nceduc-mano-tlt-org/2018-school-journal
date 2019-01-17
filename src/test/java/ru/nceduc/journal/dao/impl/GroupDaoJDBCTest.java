package ru.nceduc.journal.dao.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.bl.ConnectH2;
import ru.nceduc.journal.entity.Group;
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

public class GroupDaoJDBCTest {
    private JournalDao<Group> dao;
    Connection connection = null;

    @Before
    public void setUp() throws IOException, SQLException {
        try {
            dao = new GroupDaoJDBCImpl(ConnectH2.getConnectH2().getConnection());
            connection = ConnectH2.getConnectH2().getConnection();
            String pathGroupSql = "src/test/resources/CreatTableGroup.sql";
            String pathSection2 = "src/test/resources/CreatTableSection.sql";

            String sql = new String(Files.readAllBytes(Paths.get(pathGroupSql)));
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            sql = new String(Files.readAllBytes(Paths.get(pathSection2)));
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void cleanUp() throws SQLException {
        try {
            String dropGroupTableSQL = "DROP TABLE GROUPS";

            PreparedStatement statement = connection.prepareStatement(dropGroupTableSQL);
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void find() throws SQLException {
        UUID uuidGroup = UUID.fromString("501bfb00-e83f-4d24-8946-43590d2bedf3");
        UUID uuidProject = UUID.fromString("501bfb01-e83f-4d24-8946-43590d2bedf3");
        Project project = new Project(uuidProject.toString());
        UUID uuidSection = UUID.fromString("501bfb02-e83f-4d24-8946-43590d2bedf3");
        Section section = new Section(uuidSection.toString(), project, "Футбол");
        Group group = new Group(uuidGroup.toString(), project, section, "111");
        dao.add(group);

        Group expected = dao.find("501bfb00-e83f-4d24-8946-43590d2bedf3");
        Assert.assertEquals(expected.getId(), group.getId());
        Assert.assertEquals(expected.getSection().getId(), group.getSection().getId());
        Assert.assertEquals(expected.getProject().getId(), group.getProject().getId());
        Assert.assertEquals(expected.getSection().getSectionName(), group.getSection().getSectionName());

    }

    @Test
    public void add() throws SQLException {
        UUID uuidGroup = UUID.fromString("501bfb00-e83f-4d24-8946-43590d2bedf3");
        UUID uuidProject = UUID.fromString("501bfb01-e83f-4d24-8946-43590d2bedf3");
        Project project = new Project(uuidProject.toString());
        UUID uuidSection = UUID.fromString("501bfb02-e83f-4d24-8946-43590d2bedf3");
        Section section = new Section(uuidSection.toString(), project, "Футбол");
        Group group = new Group(uuidGroup.toString(), project, section, "111");
        Group expected = dao.find("501bfb00-e83f-4d24-8946-43590d2bedf3");

        Assert.assertEquals(expected.getId(), group.getId());
        Assert.assertEquals(expected.getSection().getId(), group.getSection().getId());
        Assert.assertEquals(expected.getProject().getId(), group.getProject().getId());
        Assert.assertEquals(expected.getSection().getSectionName(), group.getSection().getSectionName());
    }
    @Test
    public void remove() throws SQLException {
        UUID uuidGroup = UUID.fromString("501bfb00-e83f-4d24-8946-43590d2bedf3");
        UUID uuidProject = UUID.fromString("501bfb01-e83f-4d24-8946-43590d2bedf3");
        Project project = new Project(uuidProject.toString());
        UUID uuidSection = UUID.fromString("501bfb02-e83f-4d24-8946-43590d2bedf3");
        Section section = new Section(uuidSection.toString(), project, "Футбол");
        Group group = new Group(uuidGroup.toString(), project, section, "111");
        Group expected = dao.find("501bfb00-e83f-4d24-8946-43590d2bedf3");

        Assert.assertEquals(expected.getId(), group.getId());
        Assert.assertEquals(expected.getSection().getId(), group.getSection().getId());
        Assert.assertEquals(expected.getProject().getId(), group.getProject().getId());
        Assert.assertEquals(expected.getSection().getSectionName(), group.getSection().getSectionName());
    }

    @Test
    public void findAll() {
        UUID uuidProject = UUID.fromString("501bfb01-e83f-4d24-8946-43590d2bedf3");
        Project project = new Project(uuidProject.toString());
        UUID uuidSection = UUID.fromString("501bfb02-e83f-4d24-8946-43590d2bedf3");
        Section section = new Section(uuidSection.toString(),project,"Музыка");
        UUID uuidGroup = UUID.fromString("501bfb33-e83f-4d24-8946-43590d2bedf3");
        Group groupOne = new Group(uuidGroup.toString(),project,section,"10");
        Group groupSec = new Group(uuidGroup.toString(),project,section,"11");
        Group groupThird = new Group(uuidGroup.toString(),project,section,"12");

        dao.add(groupOne);
        dao.add(groupSec);
        dao.add(groupThird);

        Collection<Group> actual = dao.findAll();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertEquals(3,actual.size());

    }

    @Test
    public void update() {
        UUID uuidProject = UUID.fromString("501bfb01-e83f-4d24-8946-43590d2bedf3");
        Project project = new Project(uuidProject.toString());
        UUID uuidSection = UUID.fromString("501bfb02-e83f-4d24-8946-43590d2bedf3");
        Section section = new Section(uuidSection.toString(),project,"Футбол");
        UUID uuidGroupOne = UUID.fromString("501bfb33-e83f-4d24-8946-43590d2bedf3");
        UUID uuidGroupSec = UUID.fromString("501bfb44-e83f-4d24-8946-43590d2bedf3");
        Group actual = new Group(uuidGroupOne.toString(),project,section,"11");
        Group expected = new Group(uuidGroupSec.toString(),project,section,"12");
        dao.add(actual);
        dao.update(expected);

        Assert.assertEquals(expected.getId(),"501bfb44-e83f-4d24-8946-43590d2bedf3");
        Assert.assertEquals(expected.getSection().getId(),actual.getSection().getId());
        Assert.assertEquals(expected.getProject().getId(),actual.getProject().getId());
        Assert.assertEquals(expected.getSection().getSectionName(),"Футбол");
    }

}
