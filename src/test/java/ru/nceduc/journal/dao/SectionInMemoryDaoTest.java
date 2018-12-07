package ru.nceduc.journal.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import java.util.Collection;
import static org.junit.Assert.*;

public class SectionInMemoryDaoTest {

    private JournalDao<Section> dao;

    @Before
    public void setUp() {
        dao = new GenericInMemoryDao<>();

        Project projectOne = new Project("0");
        Project projectSecond = new Project("1");

        Section sectionOne = new Section("2" ,projectOne);
        Section sectionSec = new Section("3" ,projectSecond);

        dao.add(sectionOne);
        dao.add(sectionSec);
    }

    @After
    public void cleanUp() {
        dao = null;
    }

    @Test
    public void testFindSection() {
        Section actual = dao.find("2");

        Assert.assertEquals("2", actual.getId());
        Assert.assertEquals("0", actual.getProject().getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTeacherOnFail_1() {
        dao.find(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTeacherOnFail_2() {
        dao.find("");
    }

    @Test
    public void testAddSection() {
        Section section = new Section("0", new Project("1"));
        dao.add(section);

        Section actual = dao.find("0");
        Assert.assertEquals("0",actual.getId());
        Assert.assertEquals("1",actual.getProject().getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTeacherOnFail_1() {
        dao.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTeacherOnFail_2() {
        dao.add(new Section("", null));
    }

    @Test
    public void testRemoveSection() {
        Section sectionOne = new Section("2",new Project("0"));
        Section sectionSec = new Section("3",new Project("1"));

        dao.add(sectionOne);
        dao.add(sectionSec);

        dao.remove("2");
        assertEquals(1,dao.findAll().size());
        assertEquals("3",dao.find("3").getId());
        assertEquals("1",dao.find("3").getProject().getId());
    }

    @Test
    public void testFindAllSection() {
        Collection<Section> actual = dao.findAll();

        Assert.assertFalse(actual.isEmpty());
        Assert.assertEquals(2, actual.size());
    }

    @Test
    public void testUpdateSection() {
        Section section = new Section ("1", new Project("0"));
        dao.update(section);

        Section acual = dao.find("1");
        Assert.assertEquals("1",acual.getId());
        Assert.assertEquals("0",acual.getProject().getId());
        Assert.assertFalse(dao.findAll().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTeacherOnFail_1() {
        dao.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTeacherOnFail_2() {
        dao.update(new Section("", null));
    }
}