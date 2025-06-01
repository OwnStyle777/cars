package com.martin.cars.utils;

import com.martin.cars.exception.IdMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

public class HelperMethods {
    public static void validateIds(Long pathId, Long bodyId) {
        if (!Objects.equals(pathId, bodyId)) {
            throw new IdMismatchException("ID in path and body must match");
        }
    }

}
