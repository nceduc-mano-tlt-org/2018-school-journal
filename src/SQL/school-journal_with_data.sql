DROP TABLE IF EXISTS "gr2st";
CREATE TABLE "public"."gr2st" (
    "gr2st_group_id" text NOT NULL,
    "gr2st_project_id" text NOT NULL,
    "gr2st_student_id" text NOT NULL
) WITH (oids = false);


DROP TABLE IF EXISTS "gr2te";
CREATE TABLE "public"."gr2te" (
    "gr2te_group_id" text NOT NULL,
    "gr2te_project_id" text NOT NULL,
    "gr2te_teacher_id" text NOT NULL
) WITH (oids = false);


DROP TABLE IF EXISTS "group";
CREATE TABLE "public"."group" (
    "group_id" text NOT NULL,
    "group_project_id" text NOT NULL,
    "group_name" text NOT NULL,
    "group_section_id" text NOT NULL,
    CONSTRAINT "group_group_id" PRIMARY KEY ("group_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."group"."group_id" IS 'PK';

COMMENT ON COLUMN "public"."group"."group_project_id" IS 'FK';


DROP TABLE IF EXISTS "project";
CREATE TABLE "public"."project" (
    "project_id" text NOT NULL,
    "project_created_date" text NOT NULL,
    "project_modified_date" text,
    "project_name" text,
    CONSTRAINT "PK" PRIMARY KEY ("project_id")
) WITH (oids = false);


DROP TABLE IF EXISTS "section";
CREATE TABLE "public"."section" (
    "section_id" text NOT NULL,
    "section_project_id" text NOT NULL,
    "section_name" text NOT NULL,
    CONSTRAINT "PK_section" PRIMARY KEY ("section_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."section"."section_id" IS 'PK';

COMMENT ON COLUMN "public"."section"."section_project_id" IS 'FK';


DROP TABLE IF EXISTS "student";
CREATE TABLE "public"."student" (
    "student_id" text NOT NULL,
    "student_project_id" text NOT NULL,
    "student_fist_name" text NOT NULL,
    "student_last_name" text NOT NULL,
    CONSTRAINT "student_student_id" PRIMARY KEY ("student_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."student"."student_id" IS 'PK';

COMMENT ON COLUMN "public"."student"."student_project_id" IS 'FK';


DROP TABLE IF EXISTS "teacher";
CREATE TABLE "public"."teacher" (
    "teacher_id" text NOT NULL,
    "teacher_project_id" text NOT NULL,
    "teacher_fist_name" text NOT NULL,
    "teacher_last_name" text NOT NULL,
    CONSTRAINT "teacher_teacher_id" PRIMARY KEY ("teacher_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."teacher"."teacher_id" IS 'PK';

COMMENT ON COLUMN "public"."teacher"."teacher_project_id" IS 'FK';

INSERT INTO "gr2st" ("gr2st_group_id", "gr2st_project_id", "gr2st_student_id") VALUES
('1',	'1',	'1'),
('1',	'1',	'2'),
('1',	'1',	'3'),
('2',	'1',	'4'),
('2',	'1',	'5'),
('2',	'1',	'6'),
('3',	'1',	'7'),
('3',	'1',	'8'),
('3',	'1',	'9'),
('3',	'1',	'10'),
('3',	'1',	'1'),
('3',	'1',	'2');


INSERT INTO "gr2te" ("gr2te_group_id", "gr2te_project_id", "gr2te_teacher_id") VALUES
('1',	'1',	'1'),
('1',	'1',	'2'),
('2',	'1',	'2'),
('3',	'1',	'3');


INSERT INTO "group" ("group_id", "group_project_id", "group_name", "group_section_id") VALUES
('1',	'1',	'Box for kids',	'1'),
('2',	'1',	'Box for adults',	'1'),
('3',	'1',	'Footal for all',	'2');

INSERT INTO "project" ("project_id", "project_created_date", "project_modified_date", "project_name") VALUES
('1',	'2019-01-08',	'2019-01-08', 'MyProject');

INSERT INTO "section" ("section_id", "section_project_id", "section_name") VALUES
('1',	'1',	'Box'),
('2',	'1',	'Football');

INSERT INTO "student" ("student_id", "student_project_id", "student_fist_name", "student_last_name") VALUES
('1',	'1',	'Charles',	'Lawson'),
('2',	'1',	'Rhys ',	'Dixon'),
('3',	'1',	'Cody ',	'Richards'),
('4',	'1',	'Harry ',	'Read'),
('5',	'1',	'Rhys ',	'Wood'),
('6',	'1',	'Ryder ',	'Ramirez'),
('7',	'1',	'Soren ',	'Stephenson'),
('8',	'1',	'Asa ',	'Waters'),
('9',	'1',	'Beckett ',	'Page'),
('10',	'1',	'Javon ',	'Wilkins');

INSERT INTO "teacher" ("teacher_id", "teacher_project_id", "teacher_fist_name", "teacher_last_name") VALUES
('1',	'1',	'Jhon',	'Dorian'),
('2',	'1',	'Jhon',	'Wick'),
('3',	'1',	'Bob',	'Kelso');

-- 2019-01-08 07:13:48.815051+00
