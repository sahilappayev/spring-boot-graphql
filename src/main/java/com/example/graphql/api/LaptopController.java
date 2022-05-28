package com.example.graphql.api;

import com.example.graphql.dto.LaptopRequestDto;
import com.example.graphql.dto.LaptopResponseDto;
import com.example.graphql.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/laptops")
public class LaptopController {

    private final LaptopService laptopService;

    @PostMapping("create")
    public ResponseEntity<LaptopResponseDto> create(@RequestBody LaptopRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(laptopService.create(requestDto));
    }

}
