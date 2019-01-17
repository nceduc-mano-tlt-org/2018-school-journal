create table project
(
  project_id            uuid not null
    constraint "PK"
      primary key,
  project_created_date  date not null,
  project_modified_date date
);


