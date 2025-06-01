package com.martin.cars.controller;

import com.martin.cars.dto.BrandDto;
import com.martin.cars.dto.EngineDto;
import com.martin.cars.service.EngineService;
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

@Tag(name = "Engine")
@RestController
@AllArgsConstructor
@RequestMapping("/api/engine")
public class EngineController {

    private final EngineService engineService;

    @GetMapping("/{id}")
    public ResponseEntity<EngineDto> getEngineById (@PathVariable Long id){
        return ResponseEntity.ok(engineService.findByIdAsDto(id));
    }

    @GetMapping
    public ResponseEntity<List<EngineDto>> getAllEngines (@RequestParam(required = false) String sortBy, @RequestParam(defaultValue = "asc") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy != null ? sortBy : "id");
        return ResponseEntity.ok(engineService.getEngines(sort));
    }

    @PostMapping
    public ResponseEntity<EngineDto> createEngine (@Valid @RequestBody EngineDto dto){
        return ResponseEntity.ok(engineService.create(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<EngineDto> updateEngine (@PathVariable Long id, @Valid @RequestBody EngineDto dto){
        validateIds(id, dto.getId());
        return ResponseEntity.ok(engineService.update(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EngineDto> deleteEngine (@PathVariable Long id){
        return ResponseEntity.ok(engineService.delete(id));
    }
}
