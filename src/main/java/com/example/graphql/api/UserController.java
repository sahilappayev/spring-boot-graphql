package com.example.graphql.api;

import com.example.graphql.dto.UserRequestDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(requestDto));
    }

    @PostMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable UUID id, @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.update(id, requestDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<UserResponseDto> getByName(@PathVariable String name) {
        return ResponseEntity.ok().body(userService.getByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getByName(@PathVariable UUID id) {
        return ResponseEntity.ok().body(userService.getById(id));
    }


}
