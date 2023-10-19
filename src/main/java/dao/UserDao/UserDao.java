package dao.UserDao;

import entity.User;

import java.util.Optional;

public interface UserDao {
    void add (User user);
    Optional<User> getById(int id);
    Optional<User> getByUsername(String username);
    void update(User user);
}
