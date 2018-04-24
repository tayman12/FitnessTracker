package org.learning.spring.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = Goal.FIND_GOAL_REPORTS, query = "select new org.learning.spring.model.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id = e.goal.id"),
@NamedQuery(name = Goal.FIND_ALL_GOALS, query = "select g from Goal g")})
public class Goal {

    public static final String FIND_GOAL_REPORTS = "findGoalReports";
    public static final String FIND_ALL_GOALS = "findAllGoals";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min = 1, max = 120)
    private int minutes;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exercise> exercises = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
