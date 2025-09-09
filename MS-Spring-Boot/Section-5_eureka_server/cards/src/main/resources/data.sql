INSERT INTO cards (
    mobile_number, card_number, card_type,
    total_limit, amount_used, available_amount,
    created_at, created_by
)
SELECT '9876543210', 'CARD1234567890', 'VISA',
       50000, 10000, 40000,
       CURDATE(), 'system'
WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE card_number = 'CARD1234567890'and mobile_number ='9876543210'
);

INSERT INTO cards (
    mobile_number, card_number, card_type,
    total_limit, amount_used, available_amount,
    created_at, created_by
)
SELECT '9123456789', 'CARD9876543210', 'MASTERCARD',
       75000, 25000, 50000,
       CURDATE(), 'system'
WHERE NOT EXISTS (
    SELECT 1 FROM cards WHERE card_number = 'CARD9876543210' and mobile_number ='9123456789'
);