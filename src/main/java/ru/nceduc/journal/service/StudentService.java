package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Student;

import java.util.Collection;

public interface StudentService extends GenericJournalService<Student> {

    //todo Do we need to bind a student with a group at once or not?
    Student createStudent(String firstName, String lastName);

    /**
     * Assigns the specified student to the group.
     * @param studentId specifies the student which will be assigned to the group
     * @param groupId specifies the group for student's assignment
     */
    void assignToGroup(String studentId, String groupId);

    /**
     * Assigns the student to the new group instead of the old one.
     * @param oldGroupId specifies the group which is already bound with student
     * @param newGroupId specifies the group to be assigned
     */
    void reassignGroup(String oldGroupId, String newGroupId);

    /**
     * Removes the assignment of the specified group
     * @param studentId specifies the student which must be unbound from the group
     * @param groupId specifies the group which must be unbound from the student
     */
    void removeAssignment(String studentId, String groupId);

    Collection<Student> findAllInCurrentProject();
}
