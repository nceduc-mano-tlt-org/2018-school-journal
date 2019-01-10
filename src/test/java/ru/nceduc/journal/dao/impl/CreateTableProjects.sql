create table projects
(
  project_id            uuid not null
    constraint "PK"
      primary key,
  project_created_date  text not null,
  project_modified_date text
);


