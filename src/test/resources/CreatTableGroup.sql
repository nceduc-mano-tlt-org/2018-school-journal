create table groups
(
  group_id         uuid not null
    constraint group_group_id
      primary key,
  group_project_id text not null,
  group_name       text not null,
  group_section_id text
);



