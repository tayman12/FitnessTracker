package org.learning.spring.service;

import org.learning.spring.model.Goal;
import org.learning.spring.model.GoalReport;

import java.util.List;

public interface GoalService {

    Goal save(Goal goal);

    List<Goal> findAll();

    List<GoalReport> findAllGoalReports();
}
