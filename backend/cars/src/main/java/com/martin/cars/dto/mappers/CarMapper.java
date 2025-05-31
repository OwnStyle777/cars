package com.martin.cars.dto.mappers;

import com.martin.cars.dto.CarDto;
import com.martin.cars.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CarModelMapper.class})
public interface CarMapper {

    CarDto toDTO (Car car);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carModel", ignore = true)
    Car toEntity (CarDto carDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carModel", ignore = true)
    Car updateCarFromDto (CarDto carDto, @MappingTarget Car car);

    List<CarDto> toDTOlist (List<Car> cars);
}
