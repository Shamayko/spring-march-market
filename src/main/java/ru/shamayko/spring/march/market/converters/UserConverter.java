package ru.shamayko.spring.march.market.converters;

import org.springframework.stereotype.Component;
import ru.shamayko.spring.march.market.dtos.UserDto;
import ru.shamayko.spring.march.market.entities.User;

@Component
public class UserConverter {

    public UserDto entityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
