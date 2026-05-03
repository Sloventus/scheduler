package com.company.scheduler.web.screens.schedule;

import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Schedule;

@UiController("scheduler_Schedule.browse")
@UiDescriptor("schedule-browse.xml")
@LookupComponent("schedulesTable")
@LoadDataBeforeShow
public class ScheduleBrowse extends StandardLookup<Schedule> {
}