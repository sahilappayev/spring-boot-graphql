package com.example.graphql.api;

import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.entity.User;
import com.example.graphql.mapper.UserMapper;
import com.example.graphql.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Like Get
 */
@RequiredArgsConstructor
@Component
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDto getUserByName(String name) {
        return userMapper.entityToDto(userRepository.findByName(name));
    }

    public List<UserResponseDto> getUsersByName(String name) {
        return userMapper.entityToDtoList(userRepository.getAllByNameLike(name));
    }

    public UserResponseDto getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        return userMapper.entityToDto(user);
    }

}
