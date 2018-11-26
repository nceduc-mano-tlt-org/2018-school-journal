package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.SectionDao;
import ru.nceduc.journal.Project;
import ru.nceduc.journal.Section;

import java.util.HashMap;
import java.util.Map;

public class SectionInMemory implements SectionDao{
    private Map<String, Section> Sections;

    public SectionInMemory(){
        Sections = new HashMap<String, Section>();
    }

    @Override
    public void add(Section section) {
        Sections.put(section.getId(),section);
    }

    @Override
    public void create(String id, Project project) {
        Section section = new Section(id,project);
        Sections.put(section.getId(),section);
    }

    @Override
    public Section read(String id) {
        return Sections.get(id);
    }

    @Override
    public void update(String id,Section section) {
        Sections.replace(id,section);
    }

    @Override
    public void delete(Section section) {
        Sections.remove(section.getId());
    }

    @Override
    public void deleteById(String id) {
        Sections.remove(id);
    }

    @Override
    public Map<String, Section> getAll() {
        return Sections;
    }
}
