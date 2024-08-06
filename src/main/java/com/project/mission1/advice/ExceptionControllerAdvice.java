package com.project.mission1.advice;

import com.project.mission1.exception.UsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UsernameException.class)
    public ResponseEntity<?> UsernameException(UsernameException e) {
        return ResponseEntity.badRequest().body(e.getErrorMap());
    }
}
