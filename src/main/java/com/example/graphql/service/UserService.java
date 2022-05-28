package com.example.graphql.service;

import com.example.graphql.dto.UserRequestDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.entity.User;
import com.example.graphql.mapper.UserMapper;
import com.example.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Transactional
    public UserResponseDto create(UserRequestDto requestDto) {
        return userMapper
                .entityToDto(userRepository
                        .save(userMapper
                                .dtoToEntity(requestDto)));
    }

    @Transactional
    public UserResponseDto update(UUID id, UserRequestDto requestDto) {
        User user = findById(id);
        userMapper.update(user, requestDto);
        return userMapper.entityToDto(userRepository.save(user));
    }

    public UserResponseDto getById(UUID id) {
        return userMapper.entityToDto(findById(id));
    }

    /**
     * Only for internal using
     */
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id: " + id));
    }

    public UserResponseDto getByName(String name) {
        return userMapper.entityToDto(userRepository.findByName(name));
    }

    public List<UserResponseDto> getAll() {
        return userMapper.entityToDtoList(userRepository.findAll());
    }

    public List<UserResponseDto> getAllByName(String name) {
        return userMapper.entityToDtoList(userRepository.getAllByNameLike(name));
    }


}
