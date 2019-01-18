package ru.nceduc.journal.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.entity.Teacher;

import java.util.Collection;

public class TeacherInMemoryDaoTest {

    private JournalDao<Teacher> dao;

    @Before
    public void setUp() {
        dao = new GenericInMemoryDao<>();

        Project project = new Project("0");

        Section section = new Section("1" ,project,"Бокс");
        Group g1 = new Group("2", project, section,"name");
        Group g2 = new Group("3", project, section,"name");

        Teacher t1 = new Teacher("4", project, "Artur", "Batrutdinov");
        Teacher t2 = new Teacher("5", project, "Garik", "Harlamov");
        Teacher t3 = new Teacher("6", project, "Garik", "Martirosian");

        t1.assignTo(g1);
        t2.assignTo(g1);
        t3.assignTo(g2);

        dao.add(t1);
        dao.add(t2);
        dao.add(t3);
    }

    @After
    public void cleanUp() {
        dao = null;
    }

    @Test
    public void testFindTeacher() {
        Teacher actual = dao.find("4");

        Assert.assertEquals("4", actual.getId());
        Assert.assertEquals("Artur", actual.getFirstName());
        Assert.assertEquals("Batrutdinov", actual.getLastName());
        Assert.assertEquals("0", actual.getProject().getId());
        Assert.assertFalse(actual.getGroups().isEmpty());
        Assert.assertEquals("2", actual.getGroups().get(0).getId());
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
    public void testFindAllTeachers() {
        Collection<Teacher> actual = dao.findAll();

        Assert.assertFalse(actual.isEmpty());
        Assert.assertEquals(3, actual.size());
    }

    @Test
    public void testAddTeacher() {
        Teacher teacher = new Teacher("100", new Project("200"), "Endy", "Larkin");
        dao.add(teacher);

        Teacher actual = dao.find("100");

        Assert.assertEquals("100", actual.getId());
        Assert.assertEquals("Endy", actual.getFirstName());
        Assert.assertEquals("Larkin", actual.getLastName());
        Assert.assertEquals("200", actual.getProject().getId());
        Assert.assertTrue(actual.getGroups().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTeacherOnFail_1() {
        dao.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTeacherOnFail_2() {
        dao.add(new Teacher("", null, "", ""));
    }

    @Test
    public void testUpdateTeacher_1() {
        Teacher teacher = new Teacher("5", new Project("300"), "Garik", "Gipopotamov");
        dao.update(teacher);

        Teacher actual = dao.find("5");

        Assert.assertEquals("5", actual.getId());
        Assert.assertEquals("Garik", actual.getFirstName());
        Assert.assertEquals("Gipopotamov", actual.getLastName());
        Assert.assertEquals("300", actual.getProject().getId());
        Assert.assertTrue(actual.getGroups().isEmpty());
    }

    @Test
    public void testUpdateTeacher_2() {
        Teacher teacher = new Teacher("17", new Project("300"), "Garik", "Gipopotamov");
        dao.update(teacher);

        Teacher actual = dao.find("17");
        Assert.assertEquals("17", actual.getId());
        Assert.assertEquals("Garik", actual.getFirstName());
        Assert.assertEquals("Gipopotamov", actual.getLastName());
        Assert.assertEquals("300", actual.getProject().getId());
        Assert.assertTrue(actual.getGroups().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTeacherOnFail_1() {
        dao.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTeacherOnFail_2() {
        dao.update(new Teacher("", null, "", ""));
    }
}
