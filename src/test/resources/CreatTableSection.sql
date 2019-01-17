create table sections
(
  section_id         uuid not null
    constraint "PK_section"
      primary key,
  section_project_id uuid not null,
  section_name       text
);


