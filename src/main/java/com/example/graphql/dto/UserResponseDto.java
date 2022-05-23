package com.example.graphql.dto;

import com.example.graphql.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class UserResponseDto {
    private UUID id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private List<LaptopResponseDto> laptops;
    @JsonIgnore
    private User user;
    private String fullName;
}
