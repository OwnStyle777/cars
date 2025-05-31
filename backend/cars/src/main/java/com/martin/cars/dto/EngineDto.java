package com.martin.cars.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineDto {
    private Long id;

    @NotBlank(message = "Engine name is required")
    private String name;

    @NotBlank(message = "Engine type is required")
    private String type;

    @NotNull(message = "Horsepower is required")
    private Integer horsepower;

    @NotNull(message = "Car model is required")
    private CarModelDto carModel;
}