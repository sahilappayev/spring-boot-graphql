package com.example.graphql.api;

import com.example.graphql.dto.UserRequestDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.mapper.UserMapper;
import com.example.graphql.repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Like Create, Update and Delete
 */
@RequiredArgsConstructor
@Component
public class UserMutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        return userMapper
                .entityToDto(userRepository
                        .save(userMapper
                                .dtoToEntity(requestDto)));
    }

}
