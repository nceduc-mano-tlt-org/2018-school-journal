package ru.nceduc.journal.dao.test;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.nceduc.journal.dao.impl.TeacherInMemory;
import ru.nceduc.journal.entity.Teacher;

import java.util.HashMap;
import java.util.Map;


public class TeacherInMemoryTest extends TestCase {
    TeacherInMemory test = new TeacherInMemory();
    Teacher teacher1 = new Teacher("0", null, "Eduard", "Oldman");
    Teacher teacher2 = new Teacher("1", null, "Ivan", "Youngman");

    public void testAdd() {

    }

    public void testCreate() {
        Teacher expected = teacher1;
        test.create("0", null, "Eduard", "Oldman");
        Assert.assertTrue(expected.equals(test.read("0")));
    }

    public void testRead() {
        Teacher expected = teacher1;
        test.add(teacher1);
        Teacher actual = test.read("0");
        Assert.assertTrue(expected.equals(actual));
    }

    public void testUpdate() {
        Teacher expected = new Teacher("0", null, "Nikolay", "Stepanov");
        test.add(teacher1);
        Teacher updated = teacher1;
        updated.setFirstName("Nikolay");
        updated.setLastName("Stepanov");
        test.update(updated);
        Teacher actual = test.read("0");
        Assert.assertTrue(expected.equals(actual));
    }

    public void testDelete() {
        test.add(teacher1);
        test.delete(test.read("0"));
        Teacher actual = test.read("0");
        Assert.assertNull(actual);
    }

    public void testDeleteById() {
        test.create("0", null, "Nikolay", "Stepanov");
        test.deleteById("0");
        Teacher actual = test.read("0");
        Assert.assertNull(actual);
    }

    public void testGetAll() {
        Map<String, Teacher> expected = new HashMap<String, Teacher>();
        expected.put("0", teacher1);
        expected.put("1", teacher2);
        test.add(teacher1);
        test.add(teacher2);
        Map actual = test.getAll();
        Assert.assertEquals(expected, actual);
    }
}
