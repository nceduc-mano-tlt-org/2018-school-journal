package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.ManagerGroupDao;
import ru.nceduc.journal.entity.Group;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ManagerGroupDaoInMemory implements ManagerGroupDao {
    private Map<String, Group> groups;

    public ManagerGroupDaoInMemory() {
        groups = new ConcurrentHashMap<>();
    }

    public void save(Group group) {
        groups.put(group.getId(), group);
    }

//    @Override
//    public void create(String id, Project project, Section section) {
//        Group group = new Group(id, project , section);
//        groups.put(group.getId(), group);
//
//    }

    public Group getGroup(String id) {
        if (id == null) throw new IllegalArgumentException("Id can not be null");
        Group group = groups.get(id);
        if (group == null) throw new IllegalArgumentException("Group with id = " + id + " does not exist.");
        return group;
    }

    public void update(String id, Group group) {
        groups.computeIfPresent(id, (s, group1) -> group1);
    }

    public void deleteById(String id) {
        groups.remove(id);
    }

    public List<Group> getGroups() {
        return groups.entrySet()
                .stream()
                .filter(Objects::nonNull)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
