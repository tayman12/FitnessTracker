package org.learning.spring.service;

import org.learning.spring.model.Activity;
import org.learning.spring.model.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Activity> findAllActivities();

    Exercise save(Exercise exercise);
}
