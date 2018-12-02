package ru.nceduc.journal.dao.impl;

import ru.nceduc.journal.dao.SectionDao;
import ru.nceduc.journal.entity.Section;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SectionInMemory implements SectionDao{
    private Map<String, Section> sections;

    public SectionInMemory(){
        sections = new ConcurrentHashMap<>();
    }

    @Override
    public void create(Section section) {
        sections.put(section.getId(),section);
    }


    @Override
    public Section read(String id) {
        return sections.get(id);
    }

    @Override
    public void update(String id,Section section) {
        sections.replace(id,section);
    }

    @Override
    public void delete(Section section) {
        sections.remove(section.getId());
    }

    @Override
    public void deleteById(String id) {
        sections.remove(id);
    }

    @Override
    public List<Section> getAll() {
        return sections.entrySet()
                .stream()
                .filter(Objects::nonNull)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        sections.clear();
    }
}
