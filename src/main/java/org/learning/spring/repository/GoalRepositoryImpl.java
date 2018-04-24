package org.learning.spring.repository;

import org.learning.spring.model.Goal;
import org.learning.spring.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goal save(Goal goal) {
        if (goal.getId() == null) {
            entityManager.persist(goal);
            entityManager.flush();
        } else {
            goal = entityManager.merge(goal);
        }
        return goal;
    }

    @Override
    public List<Goal> findAll() {
//        Query query = entityManager.createQuery("select g from Goal g");

        TypedQuery<Goal> query = entityManager.createNamedQuery(Goal.FIND_ALL_GOALS, Goal.class);

        List<Goal> goals = query.getResultList();

        return goals;
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
//        Query query = entityManager.createQuery("select new org.learning.spring.model.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id = e.goal.id");

        TypedQuery<GoalReport> query = entityManager.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);

        List<GoalReport> goalReports = query.getResultList();

        return goalReports;
    }
}
