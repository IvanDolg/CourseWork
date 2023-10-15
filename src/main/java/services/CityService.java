package services;

import domain.City;
import storage.CityStorage.CityStorage;
import storage.CityStorage.JdbcCityStorage;

import java.util.Optional;

public class CityService {
    private static CityService instance;
    private final CityStorage storage = JdbcCityStorage.getInstance();

    public static CityService getInstance(){
        if (instance == null){
            instance = new CityService();
        }
        return instance;
    }
    private CityService() {}

    public Optional<City> getCityById(int id) {
        return storage.getById(id);
    }

    public Optional<City> getCityByName(String name) {
        return storage.getByName(name);
    }
}
