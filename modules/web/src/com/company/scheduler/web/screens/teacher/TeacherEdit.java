package com.company.scheduler.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Teacher;

@UiController("scheduler_Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")
@LoadDataBeforeShow
@DialogMode(forceDialog = true)
public class TeacherEdit extends StandardEditor<Teacher> {
}