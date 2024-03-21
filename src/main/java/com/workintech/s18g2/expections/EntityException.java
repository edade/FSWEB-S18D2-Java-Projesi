package com.workintech.s18g2.expections;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class EntityException extends RuntimeException{
    private HttpStatus httpStatus;

    public EntityException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
