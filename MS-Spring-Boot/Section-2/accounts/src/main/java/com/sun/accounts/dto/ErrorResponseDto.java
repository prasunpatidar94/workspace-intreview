package com.sun.accounts.dto;

import com.sun.accounts.constant.AccountsConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @Builder
@Schema(name = "ErrorResponse", description = "This Schema Hold  Error Response Information")
public class ErrorResponseDto {
    @Schema(description = "API Path Invoked by Clint")
    private String apiPath;
    @Schema(description = "API Error Code " ,example = AccountsConstants.STATUS_500)
    private HttpStatus errorCode;
    @Schema(description = "API Error Code Message " ,example = AccountsConstants.MESSAGE_500)
    private String errorSms;
    @Schema(description = "API Error Time ")
    private LocalDateTime errorTime;
}
