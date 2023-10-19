package dao.CountryDao;


import config.JdbcConnection;
import entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcCountryDao implements CountryDao {

    private static JdbcCountryDao instance;

    private final String GET_BY_ID = "select * from \"country\" where id = ?";
    private final String GET_BY_COUNTRY_NAME = "select * from \"country\" where name = ?";
    private final String GET_ALL = "select * from \"country\"";

    private JdbcCountryDao() {}

    public static JdbcCountryDao getInstance() {
        if (instance == null)
            instance = new JdbcCountryDao();

        return instance;
    }

    @Override
    public Optional<Country> getById(int id) {
        try {Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Country country = new Country(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );

                return Optional.of(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public Optional<Country> getByName (String name){
        try {Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_COUNTRY_NAME);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Country country = new Country(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );

                return Optional.of(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Country> getAll() {
        List<Country> allCountries = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt(1));
                country.setName(resultSet.getString(2));
                allCountries.add(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCountries;
    }
}
