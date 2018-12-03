package ru.nceduc.journal.dao;

import java.util.Collection;

public interface JournalDao<E> {

    E find(String id);

    void add(E entity);

    void remove(String id);

    Collection<E> findAll();

    void update(E entity);
}
