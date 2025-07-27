package com.sun.loans.dto;


import com.sun.loans.constant.LoansConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.concurrent.atomic.LongAccumulator;

@Getter @AllArgsConstructor @NoArgsConstructor @Setter @ToString
@Builder
@Schema(name = "ErrorResponse" , description = "It is for the prepare error response for end user ")
public class ErrorResponseDto {
    @Schema(description = "Path of API")
    private String apiPath;
    @Schema(description = "Error of Code", example = LoansConstants.MESSAGE_500)
    private HttpStatus errorCode;
    @Schema(description = "Error of Description ", example = LoansConstants.MESSAGE_500)
    private String errorSms;
    @Schema(description = "Error of DateTime", example = "2025-07-23 00:00:00.000000")
    private LocalDateTime errorTime;
}
