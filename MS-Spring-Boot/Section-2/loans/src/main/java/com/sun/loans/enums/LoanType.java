package com.sun.loans.enums;

import java.util.Arrays;

public enum LoanType {
    HOME_LOAN,
    PERSONAL_LOAN,
    EDUCATION_LOAN,
    CAR_LOAN,
    GOLD_LOAN,
    LOAN_AGAINST_PROPERTY,
    BUSINESS_LOAN,
    MSME_LOAN,
    WORKING_CAPITAL_LOAN,
    TERM_LOAN,
    STARTUP_LOAN,
    CONSUMER_DURABLE_LOAN,
    CREDIT_CARD_LOAN,
    OVERDRAFT,
    CASH_CREDIT,
    LOAN_AGAINST_SECURITIES,
    AGRICULTURAL_LOAN,
    TOP_UP_LOAN,
    BALANCE_TRANSFER_LOAN,
    INSTANT_LOAN;

    // Method to get LoanType by string (case insensitive)
    public static LoanType fromString(String loanTypeStr) {
        return Arrays.stream(LoanType.values())
                .filter(l -> l.name().equalsIgnoreCase(loanTypeStr))
                .findFirst()
                .orElse(null);
    }

    // Method to check if a loan type is valid
    public static boolean isValid(String loanTypeStr) {
        return fromString(loanTypeStr) != null;
    }

    // Optional: Pretty print name (optional helper)
    public String displayName() {
        return this.name().replace("_", " ").toLowerCase();
    }
}
