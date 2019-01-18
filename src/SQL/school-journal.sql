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


-- 2019-01-08 07:13:48.815051+00
