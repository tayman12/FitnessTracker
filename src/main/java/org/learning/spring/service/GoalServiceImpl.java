package org.learning.spring.service;

import org.learning.spring.model.Goal;
import org.learning.spring.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    GoalRepository goalRepository;

    @Override
    @Transactional
    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public List<Goal> findAll() {
        return goalRepository.findAll();
    }
}
