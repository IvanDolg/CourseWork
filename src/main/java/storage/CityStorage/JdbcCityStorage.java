package storage.CityStorage;

import config.JdbcConnection;
import domain.City;
import domain.Country;

import java.sql.*;
import java.util.Optional;

public class JdbcCityStorage implements CityStorage {
    private static JdbcCityStorage instance;
    private final String GET_BY_ID_SQL_SCRIPT = "SELECT * FROM \"сity\" JOIN \"сountry\"\n" +
            "on \"сountry\".id = \"сity\".country_id\n" +
            "WHERE \"сity\".id = ?";
    private final String GET_BY_NAME_SQL_SCRIPT = "SELECT * FROM \"сity\" JOIN \"сountry\"\n" +
            "on \"сountry\".id = \"сity\".country_id\n" +
            "WHERE \"сity\".name = ?;";
    private JdbcCityStorage() {
    }
    public static JdbcCityStorage getInstance(){
        if (instance == null){
            instance = new JdbcCityStorage();
        }
        return instance;
    }

    @Override
    public Optional<City> getById(int id) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL_SCRIPT)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                City city = new City();
                city.setId(resultSet.getInt(1));
                city.setName(resultSet.getString(2));

                Country country = new Country(
                        resultSet.getInt(4),
                        resultSet.getString(5));

                city.setCountry(country);

                return Optional.of(city);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<City> getByName(String name) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME_SQL_SCRIPT)){

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                City city = new City();
                city.setId(resultSet.getInt(1));
                city.setName(resultSet.getString(2));

                Country country = new Country(
                        resultSet.getInt(4),
                        resultSet.getString(5));

                city.setCountry(country);

                return Optional.of(city);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
