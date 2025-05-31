package com.martin.cars.dto.mappers;

import com.martin.cars.dto.BrandDto;
import com.martin.cars.dto.CarDto;
import com.martin.cars.model.Brand;
import com.martin.cars.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface BrandMapper {

    BrandDto toDTO (Brand brand);

    @Mapping(target = "id", ignore = true)
    Brand toEntity (BrandDto brandDto);

    @Mapping(target = "id", ignore = true)
    Brand updateBrandFromDto (BrandDto brandDto, @MappingTarget Brand brand);

    List<BrandDto> toDTOlist (List<Brand> brands);
}
