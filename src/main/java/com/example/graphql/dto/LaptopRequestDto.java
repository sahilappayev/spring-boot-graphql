package com.example.graphql.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class LaptopRequestDto {
    private String name;
    private float price;
    private UUID userId;
}
