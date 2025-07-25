package com.sun.loans.dto;


import com.sun.loans.enums.LoanType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
@Schema(name = "Loan", description = "This Schema Hold Loan Details")
public class LoanDto {

    @Schema(description = "Mobile Number of the Customer", example = "9876543210")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit with valid value ..!")
    private  String mobileNumber;
    @Schema(description = "Loan Number of the Loan" ,example = "LN1001")
    private  String loanNumber;
    @Schema(description = "Type of Loan" ,example = "CAR_LOAN")
    private  String loanType;
    @Schema(description = "Total Amount of Loan" ,example = "199465.976")
    private  Double totalLoanAmount;
    @Schema(description = "Paid Amount of Loan" ,example = "19895.976")
    private  Double paidAmount;
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



