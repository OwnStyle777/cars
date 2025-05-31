package com.martin.cars.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarTypeDto {
    private Long id;

    @NotBlank(message = "Car type name is required")
    private String name;
}