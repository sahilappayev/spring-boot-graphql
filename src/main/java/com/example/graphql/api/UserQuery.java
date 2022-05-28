package com.example.graphql.api;

import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.service.UserService;
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

    private final UserService userService;

    public UserResponseDto getUserByName(String name) {
        return userService.getByName(name);
    }

    public List<UserResponseDto> getUsersByName(String name) {
        return userService.getAllByName(name);
    }

    public List<UserResponseDto> getUsers() {
        return userService.getAll();
    }

    public UserResponseDto getUserById(UUID id) {
        return userService.getById(id);
    }

}
