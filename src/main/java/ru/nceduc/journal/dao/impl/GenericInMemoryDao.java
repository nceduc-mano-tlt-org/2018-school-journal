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

    public E add(E entity) {
        if (entity == null || StringUtils.isEmpty(entity.getId()))
            throw new IllegalArgumentException("Neither entity nor ID must not be null");

        return entities.putIfAbsent(entity.getId(), entity);
    }

    public E remove(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("The ID must not be null");
        }

        return entities.remove(id);
    }

    public Collection<E> findAll() {
        return new ArrayList<>(entities.values());
    }

    public E update(E entity) {
        if (entity == null || StringUtils.isEmpty(entity.getId()))
            throw new IllegalArgumentException("Neither entity nor ID must not be null");

        return entities.put(entity.getId(), entity);
    }
}
