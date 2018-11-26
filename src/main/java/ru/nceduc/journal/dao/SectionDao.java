package ru.nceduc.journal.dao;

import ru.nceduc.journal.Project;
import ru.nceduc.journal.Section;

import java.util.Map;

public interface SectionDao {
    public void add(Section section);
    public void create(String id, Project project);
    public Section read(String id);
    public void update(String id, Section section);
    public void delete(Section section);
    public void deleteById(String id);
    public Map<String, Section> getAll();
}
