package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Project;

public interface ProjectService extends GenericJournalService<Project> {

    Project createNewProject();

    /**
     * @return the project which is assigned to the user under the active session
     */
    Project getCurrentProject();
}
