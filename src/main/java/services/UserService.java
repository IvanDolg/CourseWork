package services;

import entity.User;
import dao.UserDao.JdbcUserDao;
import dao.UserDao.UserDao;

import java.util.Optional;

public class UserService {
    private static UserService instance;
    private final UserDao userStorage = JdbcUserDao.getInstance();

    public static UserService getInstance(){
        if (instance == null){
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
    }

    public void add(User user) {
        userStorage.add(user);
    }

    public Optional<User> getUserById(int id) {
        return userStorage.getById(id);
    }

    public Optional<User> getUserByName(String username) {
        return userStorage.getByUsername(username);
    }

    public void update(User user){userStorage.update(user);}
}
