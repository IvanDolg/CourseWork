package services;

import entity.Country;
import dao.CountryDao.CountryDao;
import dao.CountryDao.JdbcCountryDao;

import java.util.List;
import java.util.Optional;

public class CountryService {
    private static CountryService instance;
    private final CountryDao storage = JdbcCountryDao.getInstance();

    public static CountryService getInstance() {
        if (instance == null) {
            instance = new CountryService();
        }
        return instance;
    }

    private CountryService() {
    }

    public Optional<Country> getById(int id) {
        return storage.getById(id);
    }

    public Optional<Country> getByName(String name) {
        return storage.getByName(name);
    }

    public List<Country> getAll() {
        return storage.getAll();
    }
}
