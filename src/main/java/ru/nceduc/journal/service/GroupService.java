package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Group;

public interface GroupService extends GenericJournalService<Group> {

    void assignToSection(String groupId, String SectionId);

    void reassignSection(String oldSectionId, String newSectionId);
}
