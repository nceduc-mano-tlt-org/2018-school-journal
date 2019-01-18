package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.AbstractEntity;

import java.util.Collection;

public interface GenericJournalService<E extends AbstractEntity> {

    E remove(String id);

    E update(E entity);

    E find(String id);

    Collection<E> findAll();

}
