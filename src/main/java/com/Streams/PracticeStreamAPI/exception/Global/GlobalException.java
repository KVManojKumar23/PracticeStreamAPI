package com.Streams.PracticeStreamAPI.exception.Global;

import java.util.DuplicateFormatFlagsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Streams.PracticeStreamAPI.exception.DuplicateUserException;
import com.Streams.PracticeStreamAPI.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handelUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<String> handelDupllicateUserException(DuplicateFormatFlagsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
