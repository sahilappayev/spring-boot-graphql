package com.example.graphql.mapper;

import com.example.graphql.dto.LaptopResponseDto;
import com.example.graphql.dto.UserRequestDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.entity.Laptop;
import com.example.graphql.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<UserResponseDto> entityToDtoList(List<User> users);

    @Named("entityToDto")
    @Mapping(source = "laptops", target = "laptops", qualifiedByName = "laptopResponseDtoList")
    @Mapping(target = "user", source = "user")
    public abstract UserResponseDto entityToDto(User user);

    @Named("laptopResponseDtoList")
    @IterableMapping(qualifiedByName = "laptopResponseDto")
    protected abstract List<LaptopResponseDto> laptopResponseDtoList(List<Laptop> laptops);

    @Named("laptopResponseDto")
    @Mapping(target = "user", ignore = true)
    protected abstract LaptopResponseDto laptopResponseDto(Laptop laptop);

    public abstract User dtoToEntity(UserRequestDto userDto);

    public abstract void update(@MappingTarget User user, UserRequestDto requestDto);

}
