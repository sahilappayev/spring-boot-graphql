package com.example.graphql.service;

import com.example.graphql.dto.LaptopRequestDto;
import com.example.graphql.dto.LaptopResponseDto;
import com.example.graphql.entity.Laptop;
import com.example.graphql.entity.User;
import com.example.graphql.mapper.LaptopMapper;
import com.example.graphql.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;
    private final LaptopMapper laptopMapper;
    private final UserService userService;

    @Transactional
    public LaptopResponseDto create(LaptopRequestDto requestDto) {
        User user = userService.findById(requestDto.getUserId());
        Laptop laptop = laptopMapper.dtoToEntity(requestDto);
        laptop.setUser(user);
        return laptopMapper.entityToDto(laptopRepository.save(laptop));
    }

    @Transactional
    public LaptopResponseDto update(UUID id, LaptopRequestDto requestDto) {
        Laptop laptop = findById(id);
        User user = userService.findById(requestDto.getUserId());
        laptop.setUser(user);
        laptopMapper.update(laptop, requestDto);
        return laptopMapper.entityToDto(laptopRepository.save(laptop));
    }

    public LaptopResponseDto getById(UUID id) {
        return laptopMapper.entityToDto(findById(id));
    }

    private Laptop findById(UUID id) {
        return laptopRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Laptop not found with id: " + id));
    }

    public List<LaptopResponseDto> getAll() {
        return laptopMapper.entityToDtoList(laptopRepository.findAll());
    }

}
