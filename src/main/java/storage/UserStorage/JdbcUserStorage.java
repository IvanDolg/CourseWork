package storage.UserStorage;

import config.JdbcConnection;
import domain.Country;
import domain.User;

import java.sql.*;
import java.util.Base64;
import java.util.Optional;

public class JdbcUserStorage implements UserStorage {
    private static JdbcUserStorage instance;
    private final String INSERT = "insert into \"human\" (name, surname, username, photo, email, password, role, country_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String GET_BY_USERNAME_WITH_COUNTRY = "select * from human join country on human.country_id = country.id where username = ?";
    private final String GET_BY_ID_WITH_COUNTRY = "select * from \"human\" join \"country\" on \"human\".country_id = \"country\".id where \"human\".id = ?";
    private final String UPDATE_USER_DATA = "UPDATE human SET name = ?, surname = ?, username = ?, country_id = ?, photo = ?, email = ?, password = ?, role = ?\n" +
                                            "WHERE id = ?";

    public JdbcUserStorage() {
    }

    public static JdbcUserStorage getInstance() {
        if (instance == null) {
            instance = new JdbcUserStorage();
        }
        return instance;
    }

    @Override
    public void add(User user) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setBytes(4, Base64.getDecoder().decode(user.getPhoto()));
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setInt(8, user.getCountry().getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> getById(int id) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_WITH_COUNTRY);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setUserName(resultSet.getString(4));
                user.setPhoto(Base64.getEncoder().encodeToString(resultSet.getBytes(5)));
                user.setEmail(resultSet.getString(6));
                user.setPassword(resultSet.getString(7));
                user.setRole(resultSet.getString(8));

                Country country = new Country(
                        resultSet.getInt(9),
                        resultSet.getString(10)
                );

                user.setCountry(country);

                return Optional.of(new User());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_USERNAME_WITH_COUNTRY);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setUserName(resultSet.getString(4));
                user.setPhoto(Base64.getEncoder().encodeToString(resultSet.getBytes(5)));
                user.setEmail(resultSet.getString(6));
                user.setPassword(resultSet.getString(7));
                user.setRole(resultSet.getString(8));

                Country country = new Country(
                        resultSet.getInt(10),
                        resultSet.getString(11)
                );

                user.setCountry(country);

                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void update(User user) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DATA)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setInt(4, user.getCountry().getId());
            preparedStatement.setBytes(5, Base64.getDecoder().decode(user.getPhoto()));
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setString(8, user.getRole());
            preparedStatement.setInt(9, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
