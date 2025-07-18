package com.sun.accounts.dto;

import com.sun.accounts.constant.AccountsConstants;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Account", description = "This Schema Hold Account Details")
public class AccountsDto {

    @Schema(description = "Account number of the Customer")
    @NotEmpty(message = "Account number should not be empty ...!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits ...!")
    private Long accountNumber;

    @Schema(description = "Account Type for SunBank" , example = AccountsConstants.SAVINGS)
    @NotEmpty(message = "Account type not be null or empty ..!")
    private String accountType;

    @Schema(description = "Address of the Branch",example = AccountsConstants.ADDRESS)
    @NotEmpty(message = "Branch address not be null or empty ..!")
    private String branchAddress;
}
