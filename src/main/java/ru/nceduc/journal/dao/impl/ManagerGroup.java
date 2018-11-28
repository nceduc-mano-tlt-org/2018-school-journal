package ru.nceduc.journal.manager.imemroyGroup;

import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.entity.Section;

import java.util.HashMap;
import java.util.Map;

public class ManagerGroup implements ru.nceduc.journal.manager.iManagerGroup {
    private Map<String, Group> groups;

    public ManagerGroup() {
        groups = new HashMap<String, Group>();
    }


    public void add(Group group) {
        groups.put(group.getId(), group);
    }

    @Override
    public void create(String id, Project project, Section section) {
        Group group = new Group(id, project , section);
        groups.put(group.getId(), group);

    }


    @Override
    public Group getGroup(String id) {
        return groups.get(id);
    }
    @Override
    public void update(String id, Group group) {
        groups.replace(id, group);

    }

    @Override
    public void deleteById(String id) {
        groups.remove(id);

    }
    @Override
    public Map<String, Group> getGroups() {
        return groups;
    }
}
