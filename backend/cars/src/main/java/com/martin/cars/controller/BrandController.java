package com.martin.cars.controller;

import com.martin.cars.dto.BrandDto;
import com.martin.cars.service.BrandService;
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

@Tag(name = "Brand")
@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrandById (@PathVariable Long id){
        return ResponseEntity.ok(brandService.findByIdAsDto(id));
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAllBrands (@RequestParam (required = false) String sortBy, @RequestParam(defaultValue = "asc") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy != null ? sortBy : "id");
        return ResponseEntity.ok(brandService.getBrands(sort));
    }

    @PostMapping
    public ResponseEntity<BrandDto> createBrand (@Valid @RequestBody BrandDto dto){
        return ResponseEntity.ok(brandService.create(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<BrandDto> updateBrand (@PathVariable Long id, @Valid @RequestBody BrandDto dto){
        validateIds(id, dto.getId());
        return ResponseEntity.ok(brandService.update(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BrandDto> deleteBrand (@PathVariable Long id){
        return ResponseEntity.ok(brandService.delete(id));
    }

}
