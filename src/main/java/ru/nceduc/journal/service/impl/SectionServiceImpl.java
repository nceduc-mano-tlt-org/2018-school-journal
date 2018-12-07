package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.GenericInMemoryDao;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.service.SectionService;
import java.util.UUID;

import java.util.Collection;

public class SectionServiceImpl implements SectionService {

    private JournalDao<Section> sectionDao = new GenericInMemoryDao<>();

    @Override
    public Section remove(String id) {
        return sectionDao.remove(id);
    }

    @Override
    public Section update(Section entity) {
        return sectionDao.update(entity);
    }

    @Override
    public Section find(String id) {
        return sectionDao.find(id);
    }

    @Override
    public Collection<Section> findAll() {
        return sectionDao.findAll();
    }

    @Override
    public Collection<Section> findAllInCurrentProject() {
        throw new UnsupportedOperationException();
    }

    @Override                   // Временный агрумент Project
    public Section createSection(String name, Project project) {
        UUID uuid = UUID.randomUUID();
        Section section = new Section (uuid.toString(),project,name);

        return sectionDao.add(section);
    }
}
