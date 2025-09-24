package com.sun.accounts.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@Schema(name = "Card", description = "This Schema Hold Card Details")
public class CardsDto {
    @Schema( description = "Mobile number for Card" , example = "9999999999")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit with valid value ..!")
    private String mobileNumber;

    @Schema( description = "Number of Card" )
    @NotNull(message = "Number of Card should not be null/empty")
    private String cardNumber;

    @Schema( description = "Type of Card" )
    @NotNull(message = "Card type should not be null/empty")
    private String cardType;

    @Schema( description = "Total amount of Card" )
    @NotNull(message = "Total amount should not be null/empty")
    private Integer totalLimit;

    @Schema( description = "Total used amount of Card" )
    @Positive(message = "Used amount should not be negative")
    private Integer amountUsed;

    @Schema( description = "Available amount of Card" )
    @Positive(message = "Available amount should not be negative")
    private Integer availableAmount;
}
