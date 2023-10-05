package storage.UserStorage;

import config.JdbcConnection;
import domain.User;

import java.sql.*;
import java.util.Optional;

public class JDBCUserStorage implements UserStorage {
    private static JDBCUserStorage instance;
    private final String SAVE_USER_DATA = "INSERT INTO \"human\" VALUES (DEFAULT, ?, ?, ?, ?);";
    private final String GET_USER_DATA_BY_USERNAME = "SELECT * FROM \"human\" WHERE userName = ?";
    private final String UPDATE_USER_DATA = "UPDATE \"human\" SET name = ?, username = ?, password = ?, role = ?\n" +
            "WHERE id = ?";

    public JDBCUserStorage() {
    }

    public static JDBCUserStorage getInstance() {
        if (instance == null) {
            instance = new JDBCUserStorage();
        }
        return instance;
    }

    @Override
    public void save(User user) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER_DATA)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> getByUsername(String username) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_DATA_BY_USERNAME)) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String username2 = resultSet.getString(3);
                String password = resultSet.getString(4);
                String role = resultSet.getString(5);

                return Optional.of(new User(id, name, username2, password, role));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(User user) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DATA)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setInt(5, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
