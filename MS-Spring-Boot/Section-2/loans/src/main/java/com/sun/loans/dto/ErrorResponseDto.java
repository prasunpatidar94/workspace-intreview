package com.sun.loans.dto;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @AllArgsConstructor @NoArgsConstructor @Setter @ToString
@Builder
public class ErrorResponseDto {
    private String apiPath;
    private HttpStatus errorCode;
    private String errorSms;
    private LocalDateTime errorTime;
}
