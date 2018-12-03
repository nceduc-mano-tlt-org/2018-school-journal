package ru.nceduc.journal.dao.impl;

import org.apache.commons.lang3.StringUtils;
import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericInMemoryDao<E extends AbstractEntity> implements JournalDao<E> {

    private final Map<String, E> entities = new HashMap<>();

    public E find(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("The ID must not be null");
        }

        return entities.get(id);
    }

    public void add(E entity) {
        if (entity == null || StringUtils.isEmpty(entity.getId()))
            throw new IllegalArgumentException("Neither entity nor ID must not be null");

        entities.putIfAbsent(entity.getId(), entity);
    }

    public void remove(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("The ID must not be null");
        }

        entities.remove(id);
    }

    public Collection<E> findAll() {
        return new ArrayList<>(entities.values());
    }

    public void update(E entity) {
        if (entity == null || StringUtils.isEmpty(entity.getId()))
            throw new IllegalArgumentException("Neither entity nor ID must not be null");

        if (entities.containsKey(entity.getId()))
            entities.put(entity.getId(), entity);
    }
}
