package com.company.scheduler.web.screens.student;

import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Student;

@UiController("scheduler_Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
@LoadDataBeforeShow
@DialogMode(forceDialog = true)
public class StudentEdit extends StandardEditor<Student> {
}