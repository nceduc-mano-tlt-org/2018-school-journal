create table project
(
  project_id char(4) not null
    constraint project_pk
      primary key
);

create table teacher
(
  teacher_id char(4)   not null
    constraint teacher_pkey
      primary key,
  project_id char(4)   not null
    constraint teacher_project_project_id_fk
      references project,
  firstname  char(100) not null,
  lastname   char(100) not null
);

