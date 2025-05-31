package com.martin.cars.service;

import com.martin.cars.dto.CarTypeDto;
import com.martin.cars.dto.mappers.CarTypeMapper;
import com.martin.cars.exception.ResourceMissingException;
import com.martin.cars.exception.ResourceNotFoundException;
import com.martin.cars.model.CarType;
import com.martin.cars.repository.CarTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarTypeService {

    private final CarTypeRepository carTypeRepository;
    private final CarTypeMapper carTypeMapper;

    public CarType findById(Long id){
        return carTypeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Car type with this ID doesn't exist."));
    }

    public CarTypeDto findByIdAsDto(Long id){
        return carTypeMapper.toDTO(findById(id));
    }

    @Transactional
    public CarTypeDto create(CarTypeDto carTypeDto){
        CarType carType = carTypeMapper.toEntity(carTypeDto);

        return carTypeMapper.toDTO(carTypeRepository.save(carType));
    }
    @Transactional
    public CarTypeDto update(CarTypeDto carTypeDto){
        if (carTypeDto.getId() == null) {
            throw new ResourceMissingException("Car type ID is required for update.");
        }
        CarType carType = findById(carTypeDto.getId());
        CarType updatedCarType = carTypeMapper.updateCarTypeFromDto(carTypeDto, carType);

        return carTypeMapper.toDTO(carTypeRepository.save(updatedCarType));
    }
    @Transactional
    public CarTypeDto delete(Long id){
        CarType carType = findById(id);

        carTypeRepository.delete(carType);

        return carTypeMapper.toDTO(carType);
    }

    public List<CarTypeDto> getCarTypes(Sort sort) {
        return carTypeMapper.toDTOlist(carTypeRepository.findAll(sort));
    }

}
