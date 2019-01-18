package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Section;

import java.util.Collection;

public interface SectionService extends GenericJournalService<Section> {

    Section createSection(String name);

    Collection<Section> findAllInCurrentProject();
}
