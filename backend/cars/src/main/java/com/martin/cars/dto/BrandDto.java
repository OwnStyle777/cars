package com.martin.cars.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDto {
    private Long id;

    @NotBlank(message = "Brand name is required")
    private String name;
}