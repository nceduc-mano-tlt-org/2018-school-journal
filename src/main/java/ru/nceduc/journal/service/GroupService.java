package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Group;

public interface GroupService extends GenericJournalService<Group> {

    /**
     * Creates new group under the specified section
     * @param name the group name
     * @param sectionId the parent section id
     * @return newly created group
     */
    Group createGroup(String name, String sectionId);

    /**
     * Assigns the specified group to the section.
     * @param groupId specifies the group which will be assigned to the section
     * @param sectionId specifies the section for group's assignment
     */
    void assignToSection(String groupId, String sectionId);

    /**
     * Assigns the group to the new section instead of the old one.
     * @param oldSectionId specifies the section which is already bound with group
     * @param newSectionId specifies the section to be assigned
     */
    void reassignSection(String oldSectionId, String newSectionId);
}
