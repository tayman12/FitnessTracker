package org.learning.spring.service;

import org.learning.spring.model.Goal;

import java.util.List;

public interface GoalService {

    Goal save(Goal goal);

    List<Goal> findAll();
}
