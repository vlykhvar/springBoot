package service;

import java.util.List;
import models.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
