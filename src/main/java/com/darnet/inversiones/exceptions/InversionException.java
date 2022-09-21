package com.darnet.inversiones.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class InversionException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public InversionException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
