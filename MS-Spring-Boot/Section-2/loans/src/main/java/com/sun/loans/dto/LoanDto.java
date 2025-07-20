package com.sun.loans.dto;


import lombok.Getter;

@Getter
public class LoanDto {

    private  String mobileNumber;
    private  String loanNumber;
    private  String loanType;
    private  Double totalLoanAmount;
    private  Double paidAmount;
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



