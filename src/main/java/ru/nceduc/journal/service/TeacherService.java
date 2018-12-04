package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Teacher;

public interface TeacherService extends GenericJournalService<Teacher> {

    void assignToGroup(String teacherId, String groupId);

    void reassignGroup(String oldGroupId, String newGroupId);
}
