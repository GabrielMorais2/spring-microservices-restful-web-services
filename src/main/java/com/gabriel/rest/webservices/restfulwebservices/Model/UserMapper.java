package com.gabriel.rest.webservices.restfulwebservices.Model;

import com.gabriel.rest.webservices.restfulwebservices.Model.Request.UserRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UserResponseDto mapToDto(User user) {
        return mapper.map(user, UserResponseDto.class);
    }

    public User mapToEntity(UserRequestDto userRequestDto) {
        return mapper.map(userRequestDto, User.class);
    }

}
