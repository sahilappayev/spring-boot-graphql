package com.example.graphql.mapper;

import com.example.graphql.dto.LaptopRequestDto;
import com.example.graphql.dto.LaptopResponseDto;
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
public abstract class LaptopMapper {

    @IterableMapping(qualifiedByName = "entityToDto")
    public abstract List<LaptopResponseDto> entityToDtoList(List<Laptop> laptops);

    @Named("entityToDto")
    @Mapping(target = "user", source = "user", qualifiedByName = "userResponseDto")
    public abstract LaptopResponseDto entityToDto(Laptop laptop);

    public abstract Laptop dtoToEntity(LaptopRequestDto requestDto);

    @Named("userResponseDto")
    @Mapping(target = "laptops", ignore = true)
    protected abstract UserResponseDto userResponseDto(User user);

    public abstract void update(@MappingTarget Laptop laptop, LaptopRequestDto requestDto);
}
