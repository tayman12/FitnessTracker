package org.learning.spring.repository;

import org.learning.spring.model.Exercise;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ExerciseRepositoryImpl implements ExerciseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Exercise save(Exercise exercise) {
        entityManager.persist(exercise);
        entityManager.flush();
        return exercise;
    }
}
