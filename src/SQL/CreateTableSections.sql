create table sections
(
  section_id         uuid not null
    constraint "PK_section"
      primary key,
  section_project_id uuid not null,
  section_name       text not null
);

comment on column sections.section_id is 'PK';

comment on column sections.section_project_id is 'FK';



