package ru.nceduc.journal

import org.junit.Assert
import org.junit.Test
import ru.nceduc.journal.entity.Group
import ru.nceduc.journal.entity.Project
import ru.nceduc.journal.manager.imemroyGroup.ManagerGroup

class GroupTest {
    private ManagerGroup managerGroupTest = new ManagerGroup();
    private Project projectTest = new Project("0");
    private Group groupTest = new Group("0",projectTest);

    @Test
    void testGetGroup() {
        Map<String , Group> testing = new HashMap<String , Group>();
        testing.put(groupTest.getId() , groupTest);
        managerGroupTest.add(groupTest);
        Map<String , String> trues  = managerGroupTest.getGroup();
        Assert.assertEquals(testing , trues);
    }
    
    @Test
    void testAddGroup() {

    }

    @Test
    void testCreatGroup() {

    }

    @Test
    void testGetGroupGroup() {

    }

    @Test
    void testUpdateGroup() {

    }

    @Test
    void testDeleteByIdGroup() {

    }
}
