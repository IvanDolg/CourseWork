package dao.UserDao;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add (User user);
    Optional<User> getById(int id);
    Optional<User> getByUsername(String username);
    Optional<User> getUserByEmail(String email);
    void update(User user);
    List<User> getAllUsers();
    void deleteHuman(int id_person);
}
