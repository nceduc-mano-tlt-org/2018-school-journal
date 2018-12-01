package ru.nceduc.journal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.impl.TeacherInMemory;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Teacher;

import java.util.List;


public class TeacherInMemoryTest {
    private TeacherInMemory teacherInMemoryDao = new TeacherInMemory();


    @Before
    public void setUp(){
         teacherInMemoryDao.create(new Teacher("0", new Project("0"), "Nikolay", "Stepanov"));
     //  teacherInMemoryDao.create(new Teacher("1", project, "Eduard", "Oldman"));
    }

    @After
    public void tearDown(){
        teacherInMemoryDao.deleteAll();
    }

    @Test
    public void testCreate() {
        Teacher actual = teacherInMemoryDao.read("0");

        Assert.assertEquals("0", actual.getProject().getId());
        Assert.assertEquals("Nikolay", actual.getFirstName());
        Assert.assertEquals("Stepanov", actual.getLastName());
    }

    @Test
    public void testRead() {
        Teacher actual = teacherInMemoryDao.read("0");

        Assert.assertEquals("0", actual.getProject().getId());
        Assert.assertEquals("Nikolay", actual.getFirstName());
        Assert.assertEquals("Stepanov", actual.getLastName());
    }

    @Test
    public void testUpdate() {
        Teacher readedTeacher = teacherInMemoryDao.read("0");
        Project newProject = new Project("1");
        Teacher expected = new Teacher(
                readedTeacher.getId(),
                newProject,
                "Stepan",
                "Nikolayev");

        teacherInMemoryDao.update(expected);
        Teacher actual = teacherInMemoryDao.read(expected.getId());

        Assert.assertEquals(expected.getProject(), actual.getProject());
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());
    }

    @Test
    public void testDelete() {
        teacherInMemoryDao.delete("0");

       Assert.assertNull(teacherInMemoryDao.read("0"));
    }

    @Test
    public void testGetAll() {
        List<Teacher> actual = teacherInMemoryDao.getAll();

       Assert.assertNotNull(actual);
       Assert.assertEquals(1, actual.size());
    }

    @Test
    public void testDeleteAll(){
        teacherInMemoryDao.deleteAll();
        List<Teacher> actual = teacherInMemoryDao.getAll();

       Assert.assertEquals(0, actual.size());
       Assert.assertNull(teacherInMemoryDao.read("0"));
    }
}
