package com.example.graphql.api;

import com.example.graphql.dto.UserRequestDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.entity.User;
import com.example.graphql.mapper.UserMapper;
import com.example.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto requestDto) {
        User saved = userRepository.save(userMapper.dtoToEntity(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.entityToDto(saved));
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> get(@RequestParam String name) {
        return ResponseEntity.ok().body(userMapper.entityToDto(userRepository.findByName(name)));
    }


}
