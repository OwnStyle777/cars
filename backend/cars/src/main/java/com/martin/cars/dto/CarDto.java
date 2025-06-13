package com.martin.cars.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Long id;

    @NotBlank(message = "VIN is required")
    private String vin;

    @NotBlank(message = "Color is required")
    private String color;

    @NotNull(message = "Mileage is required")
    @Min(value = 0, message = "Mileage must be non-negative")
    private Integer mileage;

    @NotNull(message = "Car model is required")
    private CarModelDto carModel;

    @NotNull(message = "Year of manufacture is required")
    private Integer yearManufacture;

    @NotNull(message = "License plate is required")
    private String licensePlate;
}