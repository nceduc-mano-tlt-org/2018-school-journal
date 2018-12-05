package ru.nceduc.journal.service;

import ru.nceduc.journal.entity.Section;

public interface SectionService extends GenericJournalService<Section> {

    Section createSection(String name);
}
