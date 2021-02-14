package controllers.impl;

import controllers.UserController;
import dto.UserResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserMapper;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Autowired
    UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/inject")
    public String inject() {
        userService.add(new User("Vova",
                "Vova", "big@net.ua"));
        userService.add(new User("Jora",
                "Jora", "Jora@net.ua"));
        userService.add(new User("Jan",
                "Jan", "Jan@net.ua"));
        userService.add(new User("X Æ A-12",
                "Musk", "musk@net.ua"));
        return "inject";
    }

    @Override
    @GetMapping("{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return UserMapper.convert(userService.getById(id));
    }

    @Override
    @GetMapping("/get")
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(UserMapper::convert)
                .collect(Collectors.toList());
    }
}
