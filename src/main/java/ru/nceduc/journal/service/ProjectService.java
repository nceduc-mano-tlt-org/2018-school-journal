package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Project;

public interface ProjectService extends GenericJournalService<Project> {

    Project getCurrentProject();
}
