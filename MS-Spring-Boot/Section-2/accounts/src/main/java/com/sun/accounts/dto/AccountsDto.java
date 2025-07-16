package com.sun.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {

    @NotEmpty(message = "Account number should not be empty ...!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits ...!")
    private Long accountNumber;

    @NotEmpty(message = "Account type not be null or empty ..!")
    private String accountType;

    @NotEmpty(message = "Branch address not be null or empty ..!")
    private String branchAddress;
}
