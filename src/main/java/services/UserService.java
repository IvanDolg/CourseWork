package services;

import domain.User;
import storage.UserStorage.JDBCUserStorage;
import storage.UserStorage.UserStorage;

import java.util.Optional;

public class UserService {
    private static UserService instance;
    private final UserStorage userStorage = JDBCUserStorage.getInstance();

    public static UserService getInstance(){
        if (instance == null){
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
    }

    public void create(String name, String userName, String password, String role){
        User user = new User(name, userName, password, role);
        userStorage.save(user);
    }

    public Optional<User> findByUsername (String userName){
        return userStorage.getByUsername(userName);
    }
}
