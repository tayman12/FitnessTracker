package org.learning.spring.repository;

import org.learning.spring.model.Exercise;

public interface ExerciseRepository {
    Exercise save(Exercise exercise);
}
