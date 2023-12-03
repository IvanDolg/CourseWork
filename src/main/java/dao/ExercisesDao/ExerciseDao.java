package dao.ExercisesDao;

import entity.Exercises;
import entity.User;

import java.util.Optional;

public interface ExerciseDao {
    Optional<Exercises> getById(int id);
}
