-- begin SCHEDULER_TEACHER
create table SCHEDULER_TEACHER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end SCHEDULER_TEACHER
-- begin SCHEDULER_SCHEDULE
create table SCHEDULER_SCHEDULE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SUBJECT_ID varchar(36) not null,
    TEACHER_ID varchar(36) not null,
    DURATION integer not null,
    --
    primary key (ID)
)^
-- end SCHEDULER_SCHEDULE
-- begin SCHEDULER_SUBJECT
create table SCHEDULER_SUBJECT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end SCHEDULER_SUBJECT
-- begin SCHEDULER_STUDENT
create table SCHEDULER_STUDENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end SCHEDULER_STUDENT
-- begin SCHEDULE_STUDENT_LINK
create table SCHEDULE_STUDENT_LINK (
    SCHEDULE_ID varchar(36) not null,
    STUDENT_ID varchar(36) not null,
    primary key (SCHEDULE_ID, STUDENT_ID)
)^
-- end SCHEDULE_STUDENT_LINK
