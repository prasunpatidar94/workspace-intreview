CREATE TABLE IF NOT EXISTS loan
(
    loan_id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_by         VARCHAR(100),
    created_at         DATETIME,
    updated_by         VARCHAR(100),
    updated_at         DATETIME,
    mobile_number      VARCHAR(20),
    loan_number        VARCHAR(50),
    loan_type          VARCHAR(50),
    total_loan_amount  DOUBLE,
    paid_amount        DOUBLE,
    outstanding_amount DOUBLE
);
