create table student
(
  student_id         uuid not null
    constraint student_student_id
      primary key,
  student_project_id uuid not null,
  student_fist_name  text not null,
  student_last_name  text not null
);


