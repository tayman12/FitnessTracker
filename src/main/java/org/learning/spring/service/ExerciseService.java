package org.learning.spring.service;

import org.learning.spring.model.Activity;

import java.util.List;

public interface ExerciseService {
    List<Activity> findAllActivities();
}
