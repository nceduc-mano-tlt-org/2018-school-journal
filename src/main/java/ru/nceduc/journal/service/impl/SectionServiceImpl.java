package ru.nceduc.journal.service.impl;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.impl.ConnectorPostgreDao;
import ru.nceduc.journal.dao.impl.SectionDaoJDBC;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.entity.Project;
import ru.nceduc.journal.service.SectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.util.Collection;

public class SectionServiceImpl implements SectionService {

    Connection connection = ConnectorPostgreDao.getSingleton().getConnection();

    private JournalDao<Section> sectionDao = new SectionDaoJDBC(connection);

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
        String sql = "SELECT * FROM sections WHERE secton_project_id = '00000000-0000-0000-0000-000000000000'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Section> allSections = new ArrayList<>();
            while(resultSet.next()){
                allSections.add(SectionDaoJDBC.getReformedResultSetInSection(resultSet));
            }
            statement.close();
            return allSections;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Section createSection(String name) {
        UUID uuidProject = UUID.fromString("00000000-0000-0000-0000-000000000000");
        UUID uuidSection = UUID.randomUUID();
        // Имитация нахождения секции в определённом проекте
        Project project = new Project(uuidProject.toString());
        Section section = new Section (uuidSection.toString(),project,name);

        return sectionDao.add(section);
    }
}
