package services;

import dao.ExercisesDao.ExerciseDao;
import dao.ExercisesDao.JdbcExerciseDao;
import entity.Exercises;

public class ExercisesService {
    private static ExercisesService instance;
    private final ExerciseDao exerciseDao = JdbcExerciseDao.getInstance();

    public static ExercisesService getInstance(){
        if (instance == null){
            instance = new ExercisesService();
        }
        return instance;
    }
    public Exercises getUserById(int id) {
        return exerciseDao.getById(id);

    }
}
