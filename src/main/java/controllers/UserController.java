package controllers;

import dto.UserResponseDto;
import java.util.List;

public interface UserController {

    String inject();

    UserResponseDto get(Long userId);

    List<UserResponseDto> getAll();
}
