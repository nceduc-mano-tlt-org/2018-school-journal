package ru.nceduc.journal.dao;

import ru.nceduc.journal.entity.Section;

import java.util.List;

public interface SectionDao {
    void create(Section section);
    Section read(String id);
    public void update(String id, Section section);
    public void delete(Section section);
    public void deleteById(String id);
    public List<Section> getAll();
    void deleteAll();
}
