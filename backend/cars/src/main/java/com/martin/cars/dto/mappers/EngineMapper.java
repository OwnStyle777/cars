package com.martin.cars.dto.mappers;

import com.martin.cars.dto.CarDto;
import com.martin.cars.dto.EngineDto;
import com.martin.cars.model.Engine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CarModelMapper.class})
public interface EngineMapper {

    EngineDto toDTO (Engine engine);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carModel", ignore = true)
    Engine toEntity (EngineDto engineDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carModel", ignore = true)
    Engine updateEngineFromDto (EngineDto engineDto, @MappingTarget Engine engine);

    List<EngineDto> toDTOList (List<Engine> engines);

}
