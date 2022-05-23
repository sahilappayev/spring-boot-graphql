package com.example.graphql.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class LaptopResponseDto {
    private UUID id;
    private String name;
    private UserResponseDto user;
}
