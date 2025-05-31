package com.martin.cars.service;

import com.martin.cars.dto.CarModelDto;
import com.martin.cars.dto.mappers.CarModelMapper;
import com.martin.cars.exception.ResourceMissingException;
import com.martin.cars.exception.ResourceNotFoundException;
import com.martin.cars.model.Brand;
import com.martin.cars.model.CarModel;
import com.martin.cars.model.CarType;
import com.martin.cars.repository.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarModelService {

    private final CarModelRepository carModelRepository;
    private final CarModelMapper carModelMapper;
    private final CarTypeService carTypeService;
    private final BrandService brandService;

    public CarModel findById(Long id){
        return carModelRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Car model with this ID doesn't exist."));
    }

    public CarModelDto findByIdAsDto(Long id){
        return carModelMapper.toDTO(findById(id));
    }

    @Transactional
    public CarModelDto create (CarModelDto carModelDto){
        if(carModelDto.getCarType() == null || carModelDto.getCarType().getId() == null){
            throw new ResourceMissingException("Car type or car type ID doesn't exist for this car model");
        }
        if(carModelDto.getBrand() == null || carModelDto.getBrand().getId() == null){
            throw new ResourceMissingException("Brand or brand ID doesn't exist for this car model");
        }
        if (carModelDto.getId() == null) {
            throw new ResourceMissingException("Car model ID is required for update.");
        }
        CarType carType = carTypeService.findById(carModelDto.getCarType().getId());
        Brand brand = brandService.findById(carModelDto.getBrand().getId());

        CarModel carModel = carModelMapper.toEntity(carModelDto);
        carModel.setCarType(carType);
        carModel.setBrand(brand);

        return carModelMapper.toDTO(carModelRepository.save(carModel));
    }

    @Transactional
    public CarModelDto update (CarModelDto carModelDto){
        if(carModelDto.getCarType() == null || carModelDto.getCarType().getId() == null){
            throw new ResourceMissingException("Car type or car type ID doesn't exist for this car model");
        }
        if(carModelDto.getBrand() == null || carModelDto.getBrand().getId() == null){
            throw new ResourceMissingException("Brand or brand ID doesn't exist for this car model");
        }

        CarModel carModel = findById(carModelDto.getId());
        CarType carType = carTypeService.findById(carModelDto.getCarType().getId());
        Brand brand = brandService.findById(carModelDto.getBrand().getId());

        CarModel updatedCarModel = carModelMapper.updateCarModelFromDto(carModelDto, carModel);
        updatedCarModel.setCarType(carType);
        updatedCarModel.setBrand(brand);

        return carModelMapper.toDTO(carModelRepository.save(updatedCarModel));

    }

    @Transactional
    public CarModelDto delete (Long id){
        CarModel carModel = findById(id);
        carModelRepository.delete(carModel);

        return carModelMapper.toDTO(carModel);
    }

    public List<CarModelDto> getCarModels (Sort sort){
        return carModelMapper.toDTOlist(carModelRepository.findAll(sort));
    }

}
