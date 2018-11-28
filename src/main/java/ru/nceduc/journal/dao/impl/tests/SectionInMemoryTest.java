package ru.nceduc.journal.dao.impl.tests;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert.*;
import ru.nceduc.journal.Project;
import ru.nceduc.journal.Section;

import ru.nceduc.journal.dao.impl.SectionInMemory;

import java.util.HashMap;
import java.util.Map;

public class SectionInMemoryTest{
    private SectionInMemory sectionTest = new SectionInMemory();
    private Project projectOne = new Project("0");
    private Project projectSecond = new Project("1");
    private Section sectionOne = new Section("0",projectOne);
    private Section sectionSecond = new Section("1",projectSecond);

    @Test
    public void testAdd() {
        Section expected = sectionOne;
        sectionTest.add(sectionOne);
        Assert.assertEquals(expected,sectionTest.read(sectionOne.getId()));
        sectionTest.delete(sectionOne);
    }

    @Test
    public void testCreate() {
        Section expected = sectionOne;
        sectionTest.create("0",projectOne);
        Assert.assertEquals(expected,sectionTest.read("0"));
        sectionTest.deleteById("0");
    }

    @Test
    public void testRead() {
        Section expected = sectionOne;
        sectionTest.add(sectionOne);
        Section actual = sectionTest.read(sectionOne.getId());
        Assert.assertEquals(expected,actual);
        sectionTest.delete(sectionOne);
    }

    @Test
    public void testUpdate() {
        Section expected = new Section("1",projectSecond);
        sectionTest.add(sectionOne);
        sectionTest.update(sectionOne.getId(), sectionSecond);
        Assert.assertEquals(expected,sectionTest.read(sectionOne.getId()));
        sectionTest.deleteById(sectionOne.getId());
    }

    @Test
    public void testDelete() {
        sectionTest.add(sectionOne);
        sectionTest.delete(sectionOne);
        Section actual = sectionTest.read(sectionOne.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testDeleteById() {
        sectionTest.add(sectionOne);
        sectionTest.deleteById(sectionOne.getId());
        Section actual = sectionTest.read(sectionOne.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testGetAll() {
        Map<String, Section> expected = new HashMap <String, Section>();

        expected.put(sectionOne.getId(),sectionOne);
        expected.put(sectionSecond.getId(),sectionSecond);

        sectionTest.add(sectionOne);
        sectionTest.add(sectionSecond);

        Map<String, Section> actual = sectionTest.getAll();

        Assert.assertEquals(expected, actual);
    }
}