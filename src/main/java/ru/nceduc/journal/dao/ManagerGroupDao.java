package ru.nceduc.journal.dao;

import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.util.List;
import java.util.Map;

public interface ManagerGroupDao {
    void save(Group group);

    Group getGroup(String id);

    void update(String id, Group group);

    void deleteById(String id);

    List<Group> getGroups();

}
