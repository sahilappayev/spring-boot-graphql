package com.example.graphql.api;

import com.example.graphql.dto.LaptopRequestDto;
import com.example.graphql.dto.LaptopResponseDto;
import com.example.graphql.entity.Laptop;
import com.example.graphql.entity.User;
import com.example.graphql.mapper.LaptopMapper;
import com.example.graphql.repository.LaptopRepository;
import com.example.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/laptops")
public class LaptopController {

    private final LaptopRepository laptopRepository;
    private final LaptopMapper laptopMapper;
    private final UserRepository userRepository;

    @PostMapping("create")
    public ResponseEntity<LaptopResponseDto> create(@RequestBody LaptopRequestDto requestDto) {
        Laptop laptop = laptopMapper.dtoToEntity(requestDto);
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        laptop.setUser(user);
        Laptop saved = laptopRepository.save(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).body(laptopMapper.entityToDto(saved));
    }

}
