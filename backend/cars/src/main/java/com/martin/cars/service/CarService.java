package com.martin.cars.service;

import com.martin.cars.dto.CarDto;
import com.martin.cars.dto.mappers.CarMapper;
import com.martin.cars.exception.ResourceMissingException;
import com.martin.cars.exception.ResourceNotFoundException;
import com.martin.cars.model.Car;
import com.martin.cars.model.CarModel;
import com.martin.cars.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarModelService carModelService;

    public Car findById(Long id){
        return carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car with this ID doesn't exist."));
    }

    public CarDto findByIdAsDto(Long id){
         return carMapper.toDTO(findById(id));
    }
    @Transactional
    public CarDto create(CarDto carDto){
        if (carDto.getCarModel() == null || carDto.getCarModel().getId() == null){
            throw  new ResourceMissingException("Car model or car model ID doesn't exist for this Car.");
        }

        CarModel carModel = carModelService.findById(carDto.getCarModel().getId());
        Car car = carMapper.toEntity(carDto);
        car.setCarModel(carModel);

        return carMapper.toDTO(carRepository.save(car));
    }

    @Transactional
    public CarDto update(CarDto carDto){
        if (carDto.getCarModel() == null || carDto.getCarModel().getId() == null){
            throw  new ResourceMissingException("Car model or car model ID doesn't exist for this Car.");
        }
        if (carDto.getId() == null) {
            throw new ResourceMissingException("Car  ID is required for update.");
        }

        Car car = findById(carDto.getId());
        CarModel carModel = carModelService.findById(carDto.getCarModel().getId());

        Car updatedCar = carMapper.updateCarFromDto(carDto, car);
        updatedCar.setCarModel(carModel);

        return carMapper.toDTO(carRepository.save(updatedCar)) ;
    }

    @Transactional
    public CarDto delete(Long id){
        Car car = findById(id);
        carRepository.delete(car);

        return carMapper.toDTO(car);
    }

    public List<CarDto> getCars (Sort sort){
        return carMapper.toDTOlist(carRepository.findAll(sort));
    }
}
