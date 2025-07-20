package com.sun.loans.dto;

import lombok.*;

@Builder
@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class ResponseDto {
    private String StatusCode;
    private String StatusSms;
}
