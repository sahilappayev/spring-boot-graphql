package com.example.graphql.api;

import com.example.graphql.dto.LaptopRequestDto;
import com.example.graphql.dto.LaptopResponseDto;
import com.example.graphql.service.LaptopService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class LaptopMutation implements GraphQLMutationResolver {

    private final LaptopService laptopService;

    public LaptopResponseDto createLaptop(LaptopRequestDto requestDto) {
        return laptopService.create(requestDto);
    }

    public LaptopResponseDto updateLaptop(UUID id, LaptopRequestDto requestDto) {
        return laptopService.update(id, requestDto);
    }

}
