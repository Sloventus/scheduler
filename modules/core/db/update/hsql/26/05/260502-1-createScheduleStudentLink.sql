create table SCHEDULE_STUDENT_LINK (
    SCHEDULE_ID varchar(36) not null,
    STUDENT_ID varchar(36) not null,
    primary key (SCHEDULE_ID, STUDENT_ID)
);
