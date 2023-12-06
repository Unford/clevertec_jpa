INSERT INTO payment (payment_from, payment_to, payment_type)
VALUES ('from1', 'To1', 'ERIP'),
       ('from2', 'To2', 'ERIP'),
       ('from3', 'To3', 'ERIP'),
       ('from4', 'To4', 'REQUISITE'),
       ('from5', 'To5', 'REQUISITE'),
       ('from6', 'To6', 'REQUISITE'),
       ('from7', 'To7', 'CARD'),
       ('from8', 'To8', 'ACCOUNT'),
       ('from9', 'To9', 'PHONE');

-- Для подкласса 'payment_by_erip'
INSERT INTO payment_by_erip (id, field_for_insertion, value_for_insertion)
VALUES (1, 'Field1', 'Value1'),
       (2, 'Field2', 'Value2'),
       (3, 'Field3', 'Value3');

-- Для подкласса 'payment_by_requisite'
INSERT INTO payment_by_requisite (id, unp, receiver, destination)
VALUES (4, 'UNP1', 'Receiver1', 'Destination1'),
       (5, 'UNP2', 'Receiver2', 'Destination2'),
       (6, 'UNP3', 'Receiver3', 'Destination3');
