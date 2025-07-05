-- Insert default customers
INSERT INTO customer (name, email, mobile_number, created_at, created_by)
VALUES
  ('John Doe', 'john.doe@example.com', '1234567890', now(), 'admin'),
  ('Alice Smith', 'alice.smith@example.com', '9876543210', now(), 'admin'),
  ('Bob Johnson', 'bob.johnson@example.com', '5551234567', now(), 'admin');

-- Insert default accounts for each customer
INSERT INTO accounts (customer_id, account_type, branch_address, created_at, created_by)
VALUES
  (1, 'Savings', '123 Main St, NY', now(), 'admin'),
  (1, 'Checking', '123 Main St, NY', now(), 'admin'),
  (2, 'Savings', '456 Elm St, CA', now(), 'admin'),
  (3, 'Current', '789 Oak St, TX', now(), 'admin');

