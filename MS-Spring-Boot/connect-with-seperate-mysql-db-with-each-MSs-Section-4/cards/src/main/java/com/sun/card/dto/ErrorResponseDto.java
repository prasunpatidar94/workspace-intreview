package com.sun.card.dto;


import com.sun.card.constant.CardsConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Builder
@Schema(name = "ErrorResponse", description = "It is for the prepare error response for end user ")
public class ErrorResponseDto {
    @Schema(description = "Path of API")
    private String apiPath;
    @Schema(description = "Error of Code", example = CardsConstants.MESSAGE_500)
    private HttpStatus errorCode;
    @Schema(description = "Error of Description ", example = CardsConstants.MESSAGE_500)
    private String errorSms;
    @Schema(description = "Error of DateTime", example = "2025-07-23 00:00:00.000000")
    private LocalDateTime errorTime;
}
