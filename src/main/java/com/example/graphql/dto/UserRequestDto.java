package com.example.graphql.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UserRequestDto {
    private String name;
    private String surname;
    private LocalDate birthdate;
}
