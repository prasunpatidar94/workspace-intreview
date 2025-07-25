package com.sun.loans.exception;


import com.sun.loans.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ResourceAlreadyExistsException.class,InvalidArgumentPassedException.class })
    public ResponseEntity<ErrorResponseDto> handleConflictExceptions(ResourceAlreadyExistsException resourceAlreadyExistsException, WebRequest webRequest ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponseDto.builder()
                        .errorSms(resourceAlreadyExistsException.getMessage())
                        .apiPath(webRequest.getDescription(false))
                        .errorTime(LocalDateTime.now())
                        .errorCode(HttpStatus.BAD_REQUEST)
                        .build()
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleConflictExceptions(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponseDto.builder()
                        .errorSms(resourceNotFoundException.getMessage())
                        .apiPath(webRequest.getDescription(false))
                        .errorTime(LocalDateTime.now())
                        .errorCode(HttpStatus.BAD_REQUEST)
                        .build()
        );
    }

}
