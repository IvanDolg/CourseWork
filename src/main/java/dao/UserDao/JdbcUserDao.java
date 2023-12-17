package dao.UserDao;

import config.JdbcConnection;
import entity.Country;
import entity.User;

import javax.swing.event.ListDataEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class JdbcUserDao implements UserDao {
    private static JdbcUserDao instance;
    private final String INSERT = "insert into \"human\" (name, surname, username, photo, email, password, role, country_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String GET_BY_USERNAME_WITH_COUNTRY = "select * from human join country on human.country_id = country.id where username = ?";
    private final String GET_BY_ID_WITH_COUNTRY = "select * from \"human\" join \"country\" on \"human\".country_id = \"country\".id where \"human\".id = ?";
    private final String GET_BY_EAIL = "select * from \"human\" where \"human\".email = ?";
    private final String UPDATE_USER_DATA = "UPDATE human SET name = ?, surname = ?, username = ?, country_id = ?, photo = ?, email = ?, password = ?, role = ?\n" +
                                            "WHERE id = ?";
    private final String GET_ALL_USERS = "SELECT id, name, surname, username, email, password FROM human";
    private final String DELETE_BY_ID = "DELETE FROM human WHERE id=?";

    public JdbcUserDao() {
    }

    public static JdbcUserDao getInstance() {
        if (instance == null) {
            instance = new JdbcUserDao();
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
            preparedStatement.setString(6, Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
            preparedStatement.setInt(7, user.getRoles());
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
                user.setRoles(resultSet.getInt(8));

                Country country = new Country(
                        resultSet.getInt(10),
                        resultSet.getString(11)
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
                String password = resultSet.getString(7);
                byte[] decodedBytes = Base64.getDecoder().decode(password);
                String decodePassword = new String(decodedBytes);
                user.setPassword(decodePassword);
                user.setRoles(resultSet.getInt(8));

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
    public Optional<User> getUserByEmail(String email) {
        try (Connection connection = JdbcConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_EAIL);

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                User user = new User();

                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setUserName(resultSet.getString(4));
                user.setEmail(resultSet.getString(6));
                user.setPassword(resultSet.getString(7));

                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            preparedStatement.setInt(8, user.getRoles());
            preparedStatement.setInt(9, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));

                String password = resultSet.getString("password");
                byte[] decodedBytes = Base64.getDecoder().decode(password);
                String decodePassword = new String(decodedBytes);

                user.setPassword(decodePassword);

                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void deleteHuman(int id) {
        try(Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){

            preparedStatement.setInt(1,id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
