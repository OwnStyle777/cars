package com.martin.cars.dto.mappers;

import com.martin.cars.dto.CarDto;
import com.martin.cars.dto.CarModelDto;
import com.martin.cars.model.Car;
import com.martin.cars.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CarTypeMapper.class, BrandMapper.class })
public interface CarModelMapper {

    CarModelDto toDTO (CarModel carModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "carType", ignore = true)
    CarModel toEntity (CarModelDto carModelDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "carType", ignore = true)
    CarModel updateCarModelFromDto (CarModelDto carModelDto, @MappingTarget CarModel carModel);

    List<CarModelDto> toDTOlist (List<CarModel> carModels);
}
