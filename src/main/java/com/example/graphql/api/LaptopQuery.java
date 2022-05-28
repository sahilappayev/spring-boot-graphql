package com.example.graphql.api;

import com.example.graphql.dto.LaptopResponseDto;
import com.example.graphql.service.LaptopService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class LaptopQuery implements GraphQLQueryResolver {

    private final LaptopService laptopService;

    public List<LaptopResponseDto> getLaptops() {
        return laptopService.getAll();
    }

    public LaptopResponseDto getLaptopById(UUID id) {
        return laptopService.getById(id);
    }

}
