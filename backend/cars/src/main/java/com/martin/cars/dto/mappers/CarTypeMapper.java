package com.martin.cars.dto.mappers;

import com.martin.cars.dto.CarTypeDto;
import com.martin.cars.model.CarType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CarTypeMapper {

    CarTypeDto toDTO (CarType carType);

    @Mapping(target = "id", ignore = true)
    CarType toEntity (CarTypeDto carTypeDto);

    @Mapping(target = "id", ignore = true)
    CarType updateCarTypeFromDto (CarTypeDto carTypeDto, @MappingTarget CarType carType);
}
