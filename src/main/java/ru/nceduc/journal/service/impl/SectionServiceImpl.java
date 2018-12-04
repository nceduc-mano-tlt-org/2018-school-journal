package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.service.SectionService;

import java.util.Collection;

public class SectionServiceImpl implements SectionService {

    private JournalDao<Section> sectionDao = new GenericInMemoryDao<>();

    @Override
    public Section create() {
        return null;
    }

    @Override
    public Section remove(String id) {
        return null;
    }

    @Override
    public Section update(Section entity) {
        return null;
    }

    @Override
    public Section find(String id) {
        return null;
    }

    @Override
    public Collection<Section> findAll() {
        return null;
    }

    @Override
    public Collection<Section> findAllInCurrentProject() {
        return null;
    }
}
