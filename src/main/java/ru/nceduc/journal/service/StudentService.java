package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Student;

public interface StudentService extends GenericJournalService<Student> {

    void assignToGroup(String studentId, String groupId);

    void reassignGroup(String oldGroupId, String newGroupId);
}
