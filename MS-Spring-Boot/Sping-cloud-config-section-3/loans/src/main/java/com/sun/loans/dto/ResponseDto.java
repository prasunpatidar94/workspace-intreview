package com.sun.loans.dto;

import com.sun.loans.constant.LoansConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder @Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Schema(name = "Response" , description = "Response DTO to map responses")
public class ResponseDto {
    @Schema(description = "Code Of Response")
    private String StatusCode;
    @Schema(description = "Message Of Response")
    private String StatusSms;
}
