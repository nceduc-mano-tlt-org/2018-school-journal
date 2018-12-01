package ru.nceduc.journal.dao;

import ru.nceduc.journal.entity.Teacher;

import java.util.List;

public interface TeacherDao {

   void create(Teacher teacher);
   Teacher read(String id);
   void update(Teacher teacher);
   void delete(String id);
   List<Teacher> getAll();
   void deleteAll();
}
