package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Teacher;

public interface TeacherService extends GenericJournalService<Teacher> {

    /**
     * Assigns the specified teacher to the group.
     * @param teacherId specifies the teacher which will be assigned to the group
     * @param groupId specifies the group for teacher's assignment
     */
    void assignToGroup(String teacherId, String groupId);

    /**
     * Assigns the teacher to the new group instead of the old one.
     * @param oldGroupId specifies the group which is already bound with teacher
     * @param newGroupId specifies the group to be assigned
     */
    void reassignGroup(String oldGroupId, String newGroupId);

    /**
     * Removes the assignment of the specified group
     * @param teacherId specifies the teacher which must be unbound from the group
     * @param groupId specifies the group which must be unbound from the teacher
     */
    void removeAssignment(String teacherId, String groupId);
}
