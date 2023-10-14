package storage.UserStorage;

import domain.User;

import java.util.Optional;

public interface UserStorage {
    void add (User user);
    Optional<User> getById(int id);
    Optional<User> getByUsername(String username);
    void update(User user);
}
