package ru.nceduc.journal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.nceduc.journal.dao.impl.SectionInMemory;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SectionInMemoryTest{
    private SectionInMemory inMemorySectionDao = new SectionInMemory();
    private Project projectOne = new Project("0");
    private Project projectSecond = new Project("1");
    private Section sectionOne = new Section("0",projectOne);
    private Section sectionSecond = new Section("1",projectSecond);

    @Before
    public void setUp() {
        inMemorySectionDao.create(sectionOne);
        inMemorySectionDao.create(sectionSecond);
    }

    @Test
    public void testAdd() {
        Section expected = sectionOne;
        inMemorySectionDao.create(sectionOne);
        Assert.assertEquals(expected, inMemorySectionDao.read(sectionOne.getId()));
        inMemorySectionDao.delete(sectionOne);
    }

    @Test
    public void testCreate() {
        Section expected = sectionOne;
//        inMemorySectionDao.create("0",projectOne);
        Assert.assertEquals(expected, inMemorySectionDao.read("0"));
        inMemorySectionDao.deleteById("0");
    }

    @Test
    public void testRead() {
        Section expected = sectionOne;
        inMemorySectionDao.create(sectionOne);
        Section actual = inMemorySectionDao.read(sectionOne.getId());
        Assert.assertEquals(expected,actual);
        inMemorySectionDao.delete(sectionOne);
    }

    @Test
    public void testUpdate() {
        Section expected = new Section("1",projectSecond);
        inMemorySectionDao.create(sectionOne);
        inMemorySectionDao.update(sectionOne.getId(), sectionSecond);
        Assert.assertEquals(expected, inMemorySectionDao.read(sectionOne.getId()));
        inMemorySectionDao.deleteById(sectionOne.getId());
    }

    @Test
    public void testDelete() {
        inMemorySectionDao.create(sectionOne);
        inMemorySectionDao.delete(sectionOne);
        Section actual = inMemorySectionDao.read(sectionOne.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testDeleteById() {
        inMemorySectionDao.create(sectionOne);
        inMemorySectionDao.deleteById(sectionOne.getId());
        Section actual = inMemorySectionDao.read(sectionOne.getId());
        Assert.assertNull(actual);
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