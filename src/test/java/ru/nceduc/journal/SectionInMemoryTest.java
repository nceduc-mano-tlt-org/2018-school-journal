package ru.nceduc.journal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.impl.SectionInMemory;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SectionInMemoryTest{
    private SectionInMemory inMemorySectionDao = new SectionInMemory();

    @Before
    public void setUp() {
        inMemorySectionDao.create(new Section("0",new Project("0")));
        inMemorySectionDao.create(new Section("1",new Project("1")));
    }

    @Test
    public void testCreate() {
        Section expected = new Section("2",new Project("2"));
        inMemorySectionDao.create(expected);
        Assert.assertEquals(expected, inMemorySectionDao.read("2"));
    }

    @Test
    public void testRead() {
        Section expected = inMemorySectionDao.read("0");
        Assert.assertEquals(expected,inMemorySectionDao.read("0"));
    }

    @Test
    public void testUpdate() {
        Section expected = new Section("1",new Project("1"));
        inMemorySectionDao.update("0",expected);
        Assert.assertEquals(expected.getId(), inMemorySectionDao.read("0").getId());
        Assert.assertEquals(expected.getProject(), inMemorySectionDao.read("0").getProject());
    }

    @Test
    public void testDelete() {
        Section expected = inMemorySectionDao.read("0");
        inMemorySectionDao.delete(expected);
        List<Section> actualResult= inMemorySectionDao.getAll();
        Assert.assertEquals(1, actualResult.size());
    }

    @Test
    public void testDeleteById() {
        inMemorySectionDao.deleteById("0");
        List<Section> actualResult= inMemorySectionDao.getAll();
        Assert.assertEquals(1, actualResult.size());
    }

    @Test
    public void testGetAll() {
        List<Section> actualResult = inMemorySectionDao.getAll();
        assertNotNull(actualResult);
        assertEquals(2, actualResult.size());
    }

    @After
    public void tearDown() {
        inMemorySectionDao.deleteAll();
    }
}