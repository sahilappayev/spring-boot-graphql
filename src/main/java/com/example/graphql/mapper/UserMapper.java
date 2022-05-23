package com.example.graphql.mapper;

import com.example.graphql.dto.UserRequestDto;
import com.example.graphql.dto.UserResponseDto;
import com.example.graphql.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<UserResponseDto> entityToDtoList(List<User> users);

    @Named("entityToDto")
    @Mapping(source = "laptops", target = "laptops", ignore = true)
    @Mapping(target = "user", source = "user")
    public abstract UserResponseDto entityToDto(User user);

    public abstract User dtoToEntity(UserRequestDto userDto);

}
