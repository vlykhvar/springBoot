package dao;

import java.util.List;
import models.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
