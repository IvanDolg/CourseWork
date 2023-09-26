package storage.UserStorage;

import config.JdbcConnection;
import domain.User;

import java.sql.*;
import java.util.Optional;

public class JDBCUserStorage implements UserStorage{
    private static JDBCUserStorage instance;

    public JDBCUserStorage() {
    }
    public static JDBCUserStorage getInstance(){
        if (instance == null){
            instance = new JDBCUserStorage();
        }
        return instance;
    }

    @Override
    public void save(User user){
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"human\" VALUES (DEFAULT, ?, ?, ?, ?);")){

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
    public Optional<User> getByUsername(String username){
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from \"human\" where userName = ?")){

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
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
}
