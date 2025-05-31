package com.martin.cars.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarModelDto {
    private Long id;

    @NotBlank(message = "Car model name is required")
    private String name;

    @NotNull(message = "Year number is required")
    private Integer yearNumber;

    @NotBlank(message = "Generation type is required")
    private String generationType;

    @NotNull(message = "Car type is required")
    private CarTypeDto carType;

    @NotNull(message = "Brand is required")
    private BrandDto brand;
}