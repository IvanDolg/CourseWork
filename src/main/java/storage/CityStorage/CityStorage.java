package storage.CityStorage;

import domain.City;

import java.util.Optional;

public interface CityStorage {
    Optional<City> getById(int id);
    Optional <City> getByName(String name);
}
