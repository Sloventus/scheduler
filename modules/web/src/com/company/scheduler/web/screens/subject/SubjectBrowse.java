package com.company.scheduler.web.screens.subject;

import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Subject;

@UiController("scheduler_Subject.browse")
@UiDescriptor("subject-browse.xml")
@LookupComponent("subjectsTable")
@LoadDataBeforeShow
public class SubjectBrowse extends StandardLookup<Subject> {
}