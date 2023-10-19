package dao.CityDao;

import entity.City;

import java.util.Optional;

public interface CityDao {
    Optional<City> getById(int id);
    Optional <City> getByName(String name);
}
