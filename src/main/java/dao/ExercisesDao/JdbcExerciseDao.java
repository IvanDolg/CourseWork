package dao.ExercisesDao;

import config.JdbcConnection;
import dao.UserDao.JdbcUserDao;
import entity.Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcExerciseDao implements ExerciseDao{
    private static JdbcExerciseDao instance;

    private final String GET_BY_ID_WITH_COUNTRY = "select * from \"exercise\" where \"exercise\".id = ?";

    public JdbcExerciseDao() {
    }

    public static JdbcExerciseDao getInstance() {
        if (instance == null) {
            instance = new JdbcExerciseDao();
        }
        return instance;
    }
    @Override
    public Optional<Exercises> getById(int id) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_WITH_COUNTRY);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Exercises exercises = new Exercises();

                exercises.setId(resultSet.getInt(1));
                exercises.setName(resultSet.getString(2));
                exercises.setDescription(resultSet.getString(3));
                exercises.setRightCode(resultSet.getString(4));
                exercises.setScores(resultSet.getInt(5));

                return Optional.of(new Exercises());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
