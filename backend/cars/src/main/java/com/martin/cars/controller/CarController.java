package com.martin.cars.controller;

import com.martin.cars.dto.CarDto;
import com.martin.cars.dto.CarTypeDto;
import com.martin.cars.service.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.martin.cars.utils.HelperMethods.validateIds;

@Tag(name = "Car")
@RestController
@AllArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById (@PathVariable Long id){
        return ResponseEntity.ok(carService.findByIdAsDto(id));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars (@RequestParam(required = false) String sortBy, @RequestParam (defaultValue = "asc") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy != null ? sortBy  : "id" );
        return ResponseEntity.ok(carService.getCars(sort));
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar (@Valid @RequestBody CarDto dto){
        return ResponseEntity.ok(carService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar (@PathVariable Long id, @Valid @RequestBody CarDto dto){
        validateIds(id, dto.getId());

        return ResponseEntity.ok(carService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDto> deleteCar (@PathVariable Long id){
        return ResponseEntity.ok(carService.delete(id));
    }
}

