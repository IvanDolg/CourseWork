package storage.UserStorage;

import domain.User;

import java.util.Optional;

public interface UserStorage {
    void save (User user);
    Optional<User> getByUsername(String username);
}
