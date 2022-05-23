package com.example.graphql.resolver;

import com.example.graphql.dto.LaptopResponseDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.entity.Laptop;
import com.example.graphql.mapper.LaptopMapper;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  Managing queries with Resolver to optimize while retrieving data
 */
@RequiredArgsConstructor
@Service
public class UserResponseResolver implements GraphQLResolver<UserResponseDto> {

    private final LaptopMapper laptopMapper;

    public List<LaptopResponseDto> getLaptops(UserResponseDto userResponseDto, String name) {
        List<LaptopResponseDto> laptopResponseDtos = new ArrayList<>();
        if (userResponseDto.getUser().getLaptops() != null) {
            for (Laptop laptop : userResponseDto.getUser().getLaptops()) {
                if (name != null) {
                    if (laptop.getName().equalsIgnoreCase(name)) {
                        laptopResponseDtos.add(laptopMapper.entityToDto(laptop));
                    }
                } else {
                    laptopResponseDtos.add(laptopMapper.entityToDto(laptop));
                }
            }
        }
        return laptopResponseDtos;
    }

    public String getFullName(UserResponseDto userResponseDto) {
        return userResponseDto.getName() + " " + userResponseDto.getSurname();
    }

}
