package com.martin.cars.controller;

import com.martin.cars.dto.CarTypeDto;
import com.martin.cars.service.CarTypeService;
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

@Tag(name = "CarType")
@RestController
@AllArgsConstructor
@RequestMapping("/api/carType")
public class CarTypeController {

    private final CarTypeService carTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<CarTypeDto> getCarTypeById (@PathVariable Long id){
        return ResponseEntity.ok(carTypeService.findByIdAsDto(id));
    }

    @GetMapping
    public ResponseEntity<List<CarTypeDto>> getAllCarTypes (@RequestParam (required = false) String sortBy, @RequestParam (defaultValue = "asc") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy != null ? sortBy  : "id" );
        return ResponseEntity.ok(carTypeService.getCarTypes(sort));
    }

    @PostMapping
    public ResponseEntity<CarTypeDto> createCarType (@Valid @RequestBody CarTypeDto dto){
        return ResponseEntity.ok(carTypeService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarTypeDto> updateCarType (@PathVariable Long id, @Valid @RequestBody CarTypeDto dto){
        validateIds(id, dto.getId());

        return ResponseEntity.ok(carTypeService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarTypeDto> deleteCarType (@PathVariable Long id){
        return ResponseEntity.ok(carTypeService.delete(id));
    }
}
