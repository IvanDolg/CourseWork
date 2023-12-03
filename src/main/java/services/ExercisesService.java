package services;

import dao.ExercisesDao.ExerciseDao;
import dao.ExercisesDao.JdbcExerciseDao;
import entity.Exercises;

import java.util.Optional;

public class ExercisesService {
    private static ExercisesService instance;
    private final ExerciseDao exerciseDao = JdbcExerciseDao.getInstance();

    public static ExercisesService getInstance(){
        if (instance == null){
            instance = new ExercisesService();
        }
        return instance;
    }
    public Optional<Exercises> getUserById(int id) {
        return exerciseDao.getById(id);

    }
}
