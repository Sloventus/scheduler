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
);