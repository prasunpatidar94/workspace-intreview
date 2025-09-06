CREATE TABLE IF NOT EXISTS loans_db.loans (
                      loan_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      mobile_number VARCHAR(20),
                      loan_number VARCHAR(50),
                      loan_type VARCHAR(50),
                      total_loan_amount DOUBLE,
                      paid_amount DOUBLE,
                      outstanding_amount DOUBLE,
                      created_by VARCHAR(100) NOT NULL,
                      created_at DATETIME NOT NULL,
                      updated_by VARCHAR(100),
                      updated_at DATETIME
);