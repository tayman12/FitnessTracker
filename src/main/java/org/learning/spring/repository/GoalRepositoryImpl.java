package org.learning.spring.repository;

import org.learning.spring.model.Goal;
import org.learning.spring.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goal save(Goal goal) {
        entityManager.persist(goal);
        entityManager.flush();

        return goal;
    }

    @Override
    public List<Goal> findAll() {
        Query query = entityManager.createQuery("select g from Goal g");

        List<Goal> goals = query.getResultList();

        return goals;
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
        Query query = entityManager.createQuery("select new org.learning.spring.model.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id = e.goal.id");

        List<GoalReport> goalReports = query.getResultList();

        return goalReports;
    }
}
