package com.mglowinski.companymanagement.rest;

import com.mglowinski.companymanagement.model.Errors;
import com.mglowinski.companymanagement.model.dto.ErrorDTO;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalResourceExceptionHandler {

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ErrorDTO> handleConflict(RuntimeException ex) {
        ErrorDTO errorDTO = buildErrorResponse(Errors.ENUM_INVALID_TYPE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    private ErrorDTO buildErrorResponse(Errors errors, String appError) {
        return ErrorDTO.builder()
                .status(errors.getCode())
                .message(errors.getMessage())
                .appError(appError)
                .build();
    }

}
