package dao;

import java.util.List;
import java.util.Optional;
import models.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    Optional<User> get(Long id);
}
