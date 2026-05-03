package com.company.scheduler.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Teacher;

@UiController("scheduler_Teacher.browse")
@UiDescriptor("teacher-browse.xml")
@LookupComponent("teachersTable")
@LoadDataBeforeShow
public class TeacherBrowse extends StandardLookup<Teacher> {
}