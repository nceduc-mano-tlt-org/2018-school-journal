package ru.nceduc.journal.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.util.Collection;
import java.util.Collections;

public class GroupInMemoryDaoTest {
    private JournalDao<Group> dao;

    @Before
    public void setUp(){
        dao = new GenericInMemoryDao<>();


        Project projectOne = new Project("1");
        Project projectTwo = new Project("2");
        Section sectionOne = new Section("1",projectOne);
        Section sectionTwo = new Section("2",projectTwo);
        Group groupOne = new Group("1",projectOne,sectionOne,"1");
        Group groupTwo = new Group("2",projectTwo,sectionTwo,"2");

        groupOne.assignTo(sectionOne);
        groupTwo.assignTo(sectionTwo);

        dao.add(groupOne);
        dao.add(groupTwo);
    }

    @After
    public void cleanUp(){
        dao = null;
    }

    @Test
    public void testFindGroup(){
        Group actual = dao.find("2");
        Assert.assertEquals("2",actual.getId());
        Assert.assertEquals("2",actual.getProject().getId());
        Assert.assertEquals("2",actual.getSection().getId());
        Assert.assertEquals("2",actual.getGroupName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindGroupOnFail_1() {
        dao.find(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindGroupOnFail_2() {
        dao.find("");
    }

    @Test
    public void testFindAllGroups(){
        Collection<Group> actual = dao.findAll();

        Assert.assertFalse(actual.isEmpty());
        Assert.assertEquals(2,actual.size());
    }

}
