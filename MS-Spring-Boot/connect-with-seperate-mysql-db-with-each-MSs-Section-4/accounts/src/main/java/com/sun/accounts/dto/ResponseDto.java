package com.sun.accounts.dto;

import com.sun.accounts.constant.AccountsConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(name = "Response", description = "This Schema Hold Response Information")
public class ResponseDto {
    @Schema(name = "Status Code of Response ")
    private String StatusCode;
    @Schema(name = "Status message of Response ")
    private String StatusSms;
}
