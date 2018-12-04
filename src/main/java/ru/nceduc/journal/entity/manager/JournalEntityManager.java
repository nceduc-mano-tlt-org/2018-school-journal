package ru.nceduc.journal.entity.manager;

import ru.nceduc.journal.entity.Group;
import ru.nceduc.journal.entity.Section;
import ru.nceduc.journal.entity.Student;
import ru.nceduc.journal.entity.Teacher;
import ru.nceduc.journal.service.ProjectService;
import ru.nceduc.journal.service.impl.ProjectServiceImpl;

import java.util.UUID;

public class JournalEntityManager {

    private static final ProjectService projectService = new ProjectServiceImpl();

    public static Teacher createTeacher(String firstName, String lastName) {
        String id = UUID.randomUUID().toString();
        return new Teacher(id, projectService.getCurrentProject(), firstName, lastName);
    }

    public static Student createStudent(String firstName, String lastName) {
        String id = UUID.randomUUID().toString();
        return new Student(id, projectService.getCurrentProject(), firstName, lastName);
    }

    public static Section createSection() {
        String id = UUID.randomUUID().toString();
        Section section = new Section(id, projectService.getCurrentProject());
        createGroup(section);

        return section;
    }

    public static Group createGroup(Section section) {
        String id = UUID.randomUUID().toString();
        return new Group(id, projectService.getCurrentProject(), section);
    }
}
