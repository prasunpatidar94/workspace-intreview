package com.sun.accounts.exception;

import com.sun.accounts.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Customize the handling of {@link MethodArgumentNotValidException}.
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the exception to handle
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} for the response to use, possibly
     * {@code null} when the response is already committed
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        Map<String,String> validationErrors = new HashMap<>();
        List<ObjectError> listOfAllErrors = ex.getBindingResult().getAllErrors();

        listOfAllErrors.forEach(erroe ->{
            String fieldName = ((FieldError)erroe).getField();
            String validationMessage = erroe.getDefaultMessage();
            validationErrors.put(fieldName,validationMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .apiPath(webRequest.getDescription(false))
                .errorCode(HttpStatus.NOT_FOUND)
                .errorSms(resourceNotFoundException.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handlerCustomerAlreadyExistsException(CustomerAlreadyExistsException customerAlreadyExistsException, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .apiPath(webRequest.getDescription(false))
                .errorCode(HttpStatus.BAD_REQUEST)
                .errorSms(customerAlreadyExistsException.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handlerGlobalException(Exception exception, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .apiPath(webRequest.getDescription(false))
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorSms(exception.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
