package storage.CountryStorage;

import domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryStorage {
    Optional<Country> getById(int id);
    Optional <Country> getByName (String name);
    List<Country> getAll ();
}
