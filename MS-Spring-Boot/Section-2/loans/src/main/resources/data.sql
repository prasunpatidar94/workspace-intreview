INSERT INTO sunbank.loan (
    loan_id, created_at, created_by, updated_at, updated_by,
    loan_number, loan_type, mobile_number,
    outstanding_amount, paid_amount, total_loan_amount
)
VALUES
    (1, NOW(), 'admin', NOW(), 'admin', 'LN1001', 'Home Loan', '9876543210', 500000.00, 100000.00, 600000.00)
ON DUPLICATE KEY UPDATE loan_id = loan_id and mobile_number = mobile_number and loan_number=loan_number;
