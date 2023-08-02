package com.gabriel.rest.webservices.restfulwebservices.Service;

import com.gabriel.rest.webservices.restfulwebservices.Model.Request.UserRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.UserResponseDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.User;
import com.gabriel.rest.webservices.restfulwebservices.Model.UserMapper;
import com.gabriel.rest.webservices.restfulwebservices.Repository.UserRepository;
import com.gabriel.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return userMapper.mapToDto(user);
    }

    public List<UserResponseDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }
    public UserResponseDto save(UserRequestDto userRequestDto){
        User user = userMapper.mapToEntity(userRequestDto);
        userRepository.save(user);
        return userMapper.mapToDto(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
