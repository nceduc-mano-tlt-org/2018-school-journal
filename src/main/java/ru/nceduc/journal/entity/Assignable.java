package ru.nceduc.journal.entity;

public interface Assignable<E extends AbstractEntity> {

    void assignTo(E target);

    void removeAssignment(E target);

    void reassign(E source, E target);
}
