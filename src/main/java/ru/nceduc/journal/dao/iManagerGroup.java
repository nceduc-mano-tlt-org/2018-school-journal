package ru.nceduc.journal.manager;

import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.util.Map;

public interface iManagerGroup {
    void add(Group group);

    void create(String id, Project project , Section section);

    Group getGroup(String id);

    void update(String id, Group group);

    void deleteById(String id);

    Map<String, Group> getGroups();

}
