package com.example.graphql.api;

import com.example.graphql.dto.UserRequestDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Like Create, Update and Delete
 */
@RequiredArgsConstructor
@Component
public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        return userService.create(requestDto);
    }

    public UserResponseDto updateUser(UUID id, UserRequestDto requestDto) {
        return userService.update(id, requestDto);
    }

}
