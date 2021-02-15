package controllers;

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
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

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

    @GetMapping("{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return userMapper.mapToDto(userService.getById(id));
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
