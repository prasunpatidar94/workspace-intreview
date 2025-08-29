package com.sun.loans.exception;


import com.sun.loans.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> listOfAllErrors = ex.getBindingResult().getAllErrors();

        listOfAllErrors.forEach(erroe -> {
            String fieldName = ((FieldError) erroe).getField();
            String validationMessage = erroe.getDefaultMessage();
            validationErrors.put(fieldName, validationMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
    }

    @ExceptionHandler({ResourceAlreadyExistsException.class, InvalidArgumentPassedException.class})
    public ResponseEntity<ErrorResponseDto> handleConflictExceptions(ResourceAlreadyExistsException resourceAlreadyExistsException, WebRequest webRequest) {
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
    public ResponseEntity<ErrorResponseDto> handleConflictExceptions(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
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
