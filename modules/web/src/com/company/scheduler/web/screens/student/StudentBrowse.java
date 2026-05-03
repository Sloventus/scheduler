package com.company.scheduler.web.screens.student;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.scheduler.entity.Student;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@UiController("scheduler_Student.browse")
@UiDescriptor("student-browse.xml")
@LookupComponent("studentsTable")
@LoadDataBeforeShow
public class StudentBrowse extends StandardLookup<Student> {

    private static final String PICKED_STUDENT_IDS_PARAM = "pickedStudentIds";
    private static final String AVAILABLE_STUDENTS_QUERY =
            "select e from scheduler_Student e where e.id not in :" + PICKED_STUDENT_IDS_PARAM;

    @Inject
    private CollectionLoader<Student> studentsDl;

    @Subscribe
    private void onInit(InitEvent event) {
        List<UUID> pickedStudentIds = getPickedStudentIds(event.getOptions());
        if (!pickedStudentIds.isEmpty()) {
            studentsDl.setQuery(AVAILABLE_STUDENTS_QUERY);
            studentsDl.setParameter(PICKED_STUDENT_IDS_PARAM, pickedStudentIds);
        }
    }

    private List<UUID> getPickedStudentIds(ScreenOptions options) {
        if (!(options instanceof MapScreenOptions)) {
            return Collections.emptyList();
        }
        Map<String, Object> params = ((MapScreenOptions) options).getParams();

        Object pickedStudentIds = params.get(PICKED_STUDENT_IDS_PARAM);
        if (!(pickedStudentIds instanceof Collection)) {
            return Collections.emptyList();
        }

        return ((Collection<?>) pickedStudentIds).stream()
                .filter(UUID.class::isInstance)
                .map(UUID.class::cast)
                .collect(Collectors.toList());
    }
}