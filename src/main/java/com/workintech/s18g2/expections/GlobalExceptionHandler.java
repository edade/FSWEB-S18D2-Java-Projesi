package com.workintech.s18g2.expections;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(EntityException exception){
        EntityErrorResponse response = new EntityErrorResponse(exception.getHttpStatus().value(), exception.getMessage(), LocalDateTime.now());
        log.error("Exception occured: ", response.toString());
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(Exception exception){
        EntityErrorResponse response = new EntityErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), LocalDateTime.now());
        log.error("Exception occured: ", response.toString());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
