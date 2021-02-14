package service;

import dto.UserResponseDto;
import models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserResponseDto convert(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getFirstName());
        userResponseDto.setId(user.getId());
        return userResponseDto;
    }
}
