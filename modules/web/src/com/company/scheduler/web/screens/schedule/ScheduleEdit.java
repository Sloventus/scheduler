package com.company.scheduler.web.screens.schedule;

import com.company.scheduler.entity.Student;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Schedule;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@UiController("scheduler_Schedule.edit")
@UiDescriptor("schedule-edit.xml")
@EditedEntityContainer("scheduleDc")
@LoadDataBeforeShow
@DialogMode(forceDialog = true)
public class ScheduleEdit extends StandardEditor<Schedule> {

    private static final String PICKED_STUDENT_IDS_PARAM = "pickedStudentIds";

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private InstanceContainer<Schedule> scheduleDc;

    @Subscribe("studentsTable.add")
    public void onStudentsTableAdd(Action.ActionPerformedEvent event) {
        Schedule schedule = getEditedEntity();
        List<Student> students = schedule.getStudents();

        Map<String, Object> screenOptionMap = new HashMap<>();
        screenOptionMap.put(PICKED_STUDENT_IDS_PARAM, getStudentIds(students));

        screenBuilders.lookup(Student.class, this)
                .withOptions(new MapScreenOptions(screenOptionMap))
                .withSelectHandler(selected -> {
                    students.addAll(selected);
                    schedule.setStudents(students);
                    scheduleDc.setItem(schedule);
                })
                .show();
    }

    private List<UUID> getStudentIds(Collection<Student> students) {
        return students.stream()
                .map(Student::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}