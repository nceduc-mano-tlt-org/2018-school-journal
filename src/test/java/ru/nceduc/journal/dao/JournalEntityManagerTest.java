package ru.nceduc.journal.dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.entity.Student;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.entity.manager.JournalEntityManager;

@Ignore
public class JournalEntityManagerTest {

    @Test
    public void createTeacherTest() {
        Teacher teacher = JournalEntityManager.createTeacher("Alex", "Smallow");

        Assert.assertEquals("Alex", teacher.getFirstName());
        Assert.assertEquals("Smallow", teacher.getLastName());
        Assert.assertNotNull(teacher.getId());
    }

    @Test
    public void createStudentTest() {
        Student student = JournalEntityManager.createStudent("Bambur", "Edith");

        Assert.assertEquals("Bambur", student.getFirstName());
        Assert.assertEquals("Edith", student.getLastName());
        Assert.assertNotNull(student.getId());
    }

    @Test
    public void createSectionTest() {
        Section section = JournalEntityManager.createSection();

        Assert.assertNotNull(section.getId());
        Assert.assertFalse(section.getGroups().isEmpty());
    }

    @Test
    public void createGroupTest() {
        Section section = JournalEntityManager.createSection();
        Group group = JournalEntityManager.createGroup(section);

        Assert.assertNotNull(group.getId());
        Assert.assertEquals(section.getId(), group.getSection().getId());
    }
}
