package com.martin.cars.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Engine")
@RestController
@AllArgsConstructor
@RequestMapping("/api/engine")
public class EngineController {
}
