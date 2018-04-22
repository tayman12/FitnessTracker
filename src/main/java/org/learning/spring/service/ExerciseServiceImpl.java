package org.learning.spring.service;

import org.learning.spring.model.Activity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<>();

        Activity run = new Activity();
        run.setDesc("Run");
        activities.add(run);

        Activity bike = new Activity();
        bike.setDesc("Bike");
        activities.add(bike);

        Activity swim = new Activity();
        swim.setDesc("Swim");
        activities.add(swim);

        return activities;
    }
}
