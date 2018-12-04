package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Group;

public interface GroupService extends GenericJournalService<Group> {

    /**
     * Assigns the specified group to the section.
     * @param groupId specifies the group which will be assigned to the section
     * @param SectionId specifies the section for group's assignment
     */
    void assignToSection(String groupId, String SectionId);

    /**
     * Assigns the group to the new section instead of the old one.
     * @param oldSectionId specifies the section which is already bound with group
     * @param newSectionId specifies the section to be assigned
     */
    void reassignSection(String oldSectionId, String newSectionId);
}
