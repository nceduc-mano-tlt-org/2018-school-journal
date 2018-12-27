package ru.nceduc.journal.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface JournalDao<E> {

    /**
     * @throws IllegalArgumentException if the id is the empty string or null
     */
    E find(String id) throws SQLException;


    /**
     * @throws IllegalArgumentException if the entity is null or its id is the empty string or null
     */
    E add(E entity);


    /**
     * @throws IllegalArgumentException if the id is the empty string or null
     */
    E remove(String id);


    Collection<E> findAll();


    /**
     * If there is no such entity then nothing will happen
     *
     * @throws IllegalArgumentException if the entity is null or its id is the empty string or null
     */
    E update(E entity);
}
