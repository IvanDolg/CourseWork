package services;

import domain.User;
import storage.JDBCUserStorage;
import java.util.Optional;

public class UserService {
    private final JDBCUserStorage userStorage = new JDBCUserStorage();

    public void create(String name, String userName, String password, String role){
        User user = new User(name, userName, password, role);
        userStorage.save(user);
    }

    public Optional<User> findByUsername (String userName){
        return userStorage.getByUsername(userName);
    }
}
