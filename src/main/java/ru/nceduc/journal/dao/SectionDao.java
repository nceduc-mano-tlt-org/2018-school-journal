package ru.nceduc.journal.dao;

import ru.nceduc.journal.Project;
import ru.nceduc.journal.Section;

import java.util.List;
import java.util.Map;

public interface SectionDao {
    void create(Section section);
//    void create(String id, Project project);
    Section read(String id);
    public void update(String id, Section section);
    public void delete(Section section);
    public void deleteById(String id);
    public List<Section> getAll();
    void deleteAll();
}
