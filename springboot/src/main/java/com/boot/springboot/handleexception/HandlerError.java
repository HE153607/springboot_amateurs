package com.boot.springboot.handleexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerError {
@ExceptionHandler(NotFound.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notfound(NotFound not){
    System.out.println("handle error");
return new ExceptionResponse(HttpStatus.NOT_FOUND, not.getMessage());
}
}
