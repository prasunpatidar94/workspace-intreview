INSERT IGNORE  INTO loans_db.loans (mobile_number, loan_number, loan_type,
                           total_loan_amount, paid_amount, outstanding_amount,
                           created_by, created_at, updated_by, updated_at)
VALUES ('9876543210', 'LN20250001', 'Home Loan', 5000000.00, 1000000.00, 4000000.00, 'admin', '2025-08-01 10:00:00',
        'admin', '2025-08-10 18:30:00'),

       ('9123456789', 'LN20250002', 'Car Loan', 1200000.00, 300000.00, 900000.00, 'admin', '2025-08-02 11:15:00',
        'admin', '2025-08-10 18:30:00'),

       ('9988776655', 'LN20250003', 'Personal Loan', 500000.00, 100000.00, 400000.00, 'admin', '2025-08-03 09:45:00',
        'admin', '2025-08-10 18:30:00');