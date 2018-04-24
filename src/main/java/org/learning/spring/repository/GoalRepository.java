package org.learning.spring.repository;

import org.learning.spring.model.Goal;
import org.learning.spring.model.GoalReport;

import java.util.List;

public interface GoalRepository {
    Goal save(Goal goal);

    List<Goal> findAll();

    List<GoalReport> findAllGoalReports();
}
