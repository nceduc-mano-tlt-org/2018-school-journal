package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.service.SectionService;

import java.util.Collection;

public class SectionServiceImpl implements SectionService {

    private JournalDao<Section> sectionDao = new GenericInMemoryDao<>();

    @Override
    public Section save() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Section remove(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Section update(Section entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Section find(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Section> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Section> findAllInCurrentProject() {
        throw new UnsupportedOperationException();
    }
}
