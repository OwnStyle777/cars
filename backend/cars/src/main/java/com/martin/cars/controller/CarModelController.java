package com.martin.cars.controller;

import com.martin.cars.dto.CarDto;
import com.martin.cars.dto.CarModelDto;
import com.martin.cars.service.CarModelService;
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

@Tag(name = "CarModel")
@RestController
@AllArgsConstructor
@RequestMapping("/api/carModel")
public class CarModelController {

    private final CarModelService carModelService;

    @GetMapping("/{id}")
    public ResponseEntity<CarModelDto> getCarModelById (@PathVariable Long id){
        return ResponseEntity.ok(carModelService.findByIdAsDto(id));
    }

    @GetMapping
    public ResponseEntity<List<CarModelDto>> getAllCarModels (@RequestParam(required = false) String sortBy, @RequestParam (defaultValue = "asc") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy != null ? sortBy  : "id" );
        return ResponseEntity.ok(carModelService.getCarModels(sort));
    }

    @PostMapping
    public ResponseEntity<CarModelDto> createCarModel (@Valid @RequestBody CarModelDto dto){
        return ResponseEntity.ok(carModelService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarModelDto> updateCarModel (@PathVariable Long id, @Valid @RequestBody CarModelDto dto){
        validateIds(id, dto.getId());

        return ResponseEntity.ok(carModelService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarModelDto> deleteCarModel (@PathVariable Long id){
        return ResponseEntity.ok(carModelService.delete(id));
    }
}
