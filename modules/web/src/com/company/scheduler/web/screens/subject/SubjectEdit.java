package com.company.scheduler.web.screens.subject;

import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Subject;

@UiController("scheduler_Subject.edit")
@UiDescriptor("subject-edit.xml")
@EditedEntityContainer("subjectDc")
@LoadDataBeforeShow
@DialogMode(forceDialog = true)
public class SubjectEdit extends StandardEditor<Subject> {
}