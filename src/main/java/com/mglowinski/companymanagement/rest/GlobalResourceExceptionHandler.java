package com.mglowinski.companymanagement.rest;

import com.mglowinski.companymanagement.model.Errors;
import com.mglowinski.companymanagement.model.dto.ErrorDTO;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalResourceExceptionHandler {

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ErrorDTO> handleConflict(ConversionFailedException ex) {
        ErrorDTO errorDTO = buildErrorResponse(Errors.ENUM_INVALID_TYPE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleConflict(EntityNotFoundException ex) {
        ErrorDTO errorDTO = buildErrorResponse(Errors.RESOURCE_NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    private ErrorDTO buildErrorResponse(Errors errors, String appError) {
        return ErrorDTO.builder()
                .status(errors.getCode())
                .message(errors.getMessage())
                .appError(appError)
                .build();
    }

}
