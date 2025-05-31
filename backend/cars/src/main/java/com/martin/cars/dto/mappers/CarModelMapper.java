package com.martin.cars.dto.mappers;

import com.martin.cars.dto.CarModelDto;
import com.martin.cars.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CarTypeMapper.class, BrandMapper.class })
public interface CarModelMapper {

    CarModelDto toDTO (CarModel carModel);

    @Mapping(target = "id", ignore = true)
    CarModel toEntity (CarModelDto carModelDto);

    @Mapping(target = "id", ignore = true)
    CarModel updateCarModelFromDto (CarModelDto carModelDto, @MappingTarget CarModel carModel);
}
