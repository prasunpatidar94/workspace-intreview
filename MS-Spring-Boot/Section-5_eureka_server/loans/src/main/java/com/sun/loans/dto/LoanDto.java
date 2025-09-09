package com.sun.loans.dto;


import com.sun.loans.enums.LoanType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
@Schema(name = "Loan", description = "This Schema Hold Loan Details")
public class LoanDto {

    @Schema(description = "Mobile Number of the Customer", example = "9876543210")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit with valid value ..!")
    @NotNull (message = "Mobile number should not be NULL/EMPTY")
    private  String mobileNumber;

    @NotEmpty(message = "Loan number should not be NULL/EMPTY")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number must be 12 digit with valid value ..!")
    @Schema(description = "Loan Number of the Loan" ,example = "LN1001")
    private  String loanNumber;

    @NotEmpty(message = "Loan Type should not be NULL/EMPTY")
    @Schema(description = "Type of Loan" ,example = "CAR_LOAN")
    private  String loanType;

    @NegativeOrZero(message = "Total Amount of Loan should not be Zero / Negative")
    @Schema(description = "Total Amount of Loan" ,example = "199465.976")
    private  Double totalLoanAmount;

    @Negative(message = "Paid Amount of Loan should not be Negative")
    @Schema(description = "Paid Amount of Loan" ,example = "19895.976")
    private  Double paidAmount;

    @Negative(message = "OutStanding Amount of Loan should be Negative")
    @Schema(description = "Paid Amount of Loan" ,example = "99465.976")
    private  Double outstandingAmount;

    public  LoanDto(){}
    private LoanDto(Builder builder) {
        this.mobileNumber = builder.mobileNumber;
        this.loanNumber = builder.loanNumber;
        this.loanType = builder.loanType;
        this.totalLoanAmount = builder.totalLoanAmount;
        this.paidAmount = builder.paidAmount;
        this.outstandingAmount = builder.outstandingAmount;
    }

    public static class Builder {
        private String mobileNumber;
        private String loanNumber;
        private String loanType;
        private Double totalLoanAmount;
        private Double paidAmount;
        private Double outstandingAmount;

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder loanNumber(String loanNumber) {
            this.loanNumber = loanNumber;
            return this;
        }

        public Builder loanType(String loanType) {
            this.loanType = loanType;
            return this;
        }

        public Builder totalLoanAmount(Double totalLoanAmount) {
            this.totalLoanAmount = totalLoanAmount;
            return this;
        }


        public Builder paidAmount(Double paidAmount) {
            this.paidAmount = paidAmount;
            return this;
        }

        public Builder outstandingAmount(Double outstandingAmount) {
            this.outstandingAmount = outstandingAmount;
            return this;
        }

        public LoanDto build() {
            return new LoanDto(this);
        }
    }

    @Override
    public String toString() {
        return "LoanDto{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", loanNumber='" + loanNumber + '\'' +
                ", loanType='" + loanType + '\'' +
                ", totalLoanAmount=" + totalLoanAmount +
                ", paidAmount=" + paidAmount +
                ", outstandingAmount=" + outstandingAmount +
                '}';
    }
}



