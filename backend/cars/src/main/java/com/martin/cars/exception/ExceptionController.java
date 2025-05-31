package com.martin.cars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponse> handleValidation (MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    if (error instanceof FieldError) {
                        return ((FieldError) error).getField() + ": " + error.getDefaultMessage();
                    }
                    return error.getDefaultMessage();
                })
                .toList();

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Validation errors : ",errors));
    }

    @ExceptionHandler(ResourceMissingException.class)
    ResponseEntity<ErrorResponse> handleMissing (ResourceMissingException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Resource missing: ",List.of(ex.getMessage())));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Resource not found: ",List.of(ex.getMessage())));
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponse> handleOthers(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Unexpected error: " ,List.of(ex.getMessage())));
    }


    public record ErrorResponse( String error, List<String> details) {

    }
}
