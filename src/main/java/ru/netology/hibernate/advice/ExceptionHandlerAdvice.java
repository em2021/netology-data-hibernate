package ru.netology.hibernate.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.hibernate.exception.NoSuchEntityException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NoSuchEntityException.class)
    public ResponseEntity<String> nSCEHandler(NoSuchEntityException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}