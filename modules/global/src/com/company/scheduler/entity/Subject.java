package com.company.scheduler.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "SCHEDULER_SUBJECT")
@Entity(name = "scheduler_Subject")
@NamePattern("%s|name")
public class Subject extends StandardEntity {
    private static final long serialVersionUID = -7938535491096166703L;

    @Column(name = "NAME", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}