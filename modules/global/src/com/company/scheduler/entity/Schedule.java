package com.company.scheduler.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Table(name = "SCHEDULER_SCHEDULE")
@Entity(name = "scheduler_Schedule")
@NamePattern("%s|subject")
public class Schedule extends StandardEntity {
    private static final long serialVersionUID = -2525046564006443079L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "SCHEDULE_STUDENT_LINK",
            joinColumns = @JoinColumn(name = "SCHEDULE_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private List<Student> students = new ArrayList<>();

    @Column(name = "DURATION", nullable = false)
    @Min(1)
    @Max(12)
    private Integer duration;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
