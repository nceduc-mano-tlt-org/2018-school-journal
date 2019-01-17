create table teacher
(
  teacher_id         uuid not null
    constraint teacher_teacher_id
      primary key,
  teacher_project_id uuid not null,
  teacher_fist_name  text not null,
  teacher_last_name  text not null
);


